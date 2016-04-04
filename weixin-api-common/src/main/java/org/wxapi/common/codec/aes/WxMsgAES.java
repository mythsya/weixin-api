package org.wxapi.common.codec.aes;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.wxapi.common.codec.SHA1;
import org.wxapi.common.util.AdapterCDATA;
import org.wxapi.common.util.JaxbHelper;

/**
 * 提供接收和推送给公众平台消息的加解密接口(UTF8编码的字符串).
 * <ol>
 * <li>第三方回复加密消息给公众平台</li>
 * <li>第三方收到公众平台发送的消息，验证消息的安全性，并对消息进行解密。</li>
 * </ol>
 * 说明：异常java.security.InvalidKeyException:illegal Key Size的解决方案
 * <ol>
 * <li>在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
 * http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124
 * .html</li>
 * <li>下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt</li>
 * <li>如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件</li>
 * <li>如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件</li>
 * </ol>
 */
public class WxMsgAES {

    static class _ByteGroup {
        List<Byte> byteContainer = new ArrayList<>();

        public _ByteGroup addBytes(final byte[] bytes) {
            for (byte b : bytes) {
                byteContainer.add(b);
            }
            return this;
        }

        public int size() {
            return byteContainer.size();
        }

        public byte[] toBytes() {
            byte[] bytes = new byte[byteContainer.size()];
            for (int i = 0; i < byteContainer.size(); i++) {
                bytes[i] = byteContainer.get(i);
            }
            return bytes;
        }
    }

    /**
     * 安全模式下，消息体只有密文，格式如下：
     *
     * <pre>
     * <xml>
     *     <ToUserName><![CDATA[toUser]]</ToUserName>
     *     <Encrypt><![CDATA[msg_encrypt]]</Encrypt>
     * </xml>
     * </pre>
     *
     * @author xgx
     *
     */
    @XmlRootElement(name = "xml")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class _InXml {
        @XmlElement(name = "ToUserName")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        String toUserName;
        @XmlElement(name = "Encrypt")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        String encrypt;

        public _InXml() {
        }

        public _InXml(final String toUserName, final String encrypt) {
            this.toUserName = toUserName;
            this.encrypt = encrypt;
        }
    }

    /**
     * 回复消息体的签名与加密。加密后消息格式：
     *
     * <pre>
     * <xml>
     *     <Encrypt><![CDATA[msg_encrypt]]></Encrypt>
     *     <MsgSignature><![CDATA[msg_signature]]></MsgSignature>
     *     <TimeStamp>timestamp</TimeStamp>
     *     <Nonce><![CDATA[nonce]]></Nonce>
     * </xml>
     * </pre>
     *
     * @author xgx
     *
     */
    @XmlRootElement(name = "xml")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class _OutXml {
        @XmlElement(name = "MsgSignature")
        String msgSignature;
        @XmlElement(name = "Encrypt")
        String encrypt;
        @XmlElement(name = "TimeStamp")
        String timeStamp;
        @XmlElement(name = "Nonce")
        String nonce;

        public _OutXml() {
        }

        public _OutXml(final String signature, final String encrypt, final String timeStamp, final String nonce) {
            this.msgSignature = signature;
            this.encrypt = encrypt;
            this.timeStamp = timeStamp;
            this.nonce = nonce;
        }
    }

    /**
     * 提供基于PKCS7算法的加解密接口.
     */
    final static class _PKCS7 {
        final static Charset CHARSET = Charset.forName("utf-8");
        final static int BLOCK_SIZE = 32;

        /**
         * 将数字转化成ASCII码对应的字符，用于对明文进行补码
         *
         * @param a
         *            需要转化的数字
         * @return 转化得到的字符
         */
        final static char chr(final int a) {
            byte target = (byte) (a & 0xFF);
            return (char) target;
        }

        /**
         * 删除解密后明文的补位字符
         *
         * @param decrypted
         *            解密后的明文
         * @return 删除补位字符后的明文
         */
        final static byte[] decode(final byte[] decrypted) {
            int pad = decrypted[decrypted.length - 1];
            if (pad < 1 || pad > 32) {
                pad = 0;
            }
            return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
        }

        /**
         * 获得对明文进行补位填充的字节.
         *
         * @param count
         *            需要进行填充补位操作的明文字节个数
         * @return 补齐用的字节数组
         */
        final static byte[] encode(final int count) {
            // 计算需要填充的位数
            int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
            if (amountToPad == 0) {
                amountToPad = BLOCK_SIZE;
            }
            // 获得补位所用的字符
            char padChr = chr(amountToPad);
            StringBuilder tmp = new StringBuilder();
            for (int index = 0; index < amountToPad; index++) {
                tmp.append(padChr);
            }
            return tmp.toString().getBytes(CHARSET);
        }

    }

    /**
     * 消息体签名
     *
     * <pre>
     * 为了验证消息体的合法性，公众平台新增消息体签名，开发者可用以验证消息体的真实性，并对验证通过的消息体进行解密
     *
     * 在url上增加参数：msg_signature
     *
     * msg_signature=sha1(sort(Token、timestamp、nonce, msg_encrypt))
     * 参数        说明
     * Token       公众平台上，开发者设置的Token
     * timestamp   URL上原有参数，时间戳
     * nonce       URL上原有参数，随机数
     * msg_encrypt 前文描述密文消息体
     * </pre>
     *
     * @author xgx
     *
     */
    final static class _SHA1 {
        /**
         * 用SHA1算法生成安全签名
         *
         * @param token
         *            票据
         * @param timestamp
         *            时间戳
         * @param nonce
         *            随机字符串
         * @param encrypt
         *            密文
         * @return 安全签名
         * @throws AesException
         */
        public static String signature(final String token, final String timestamp, final String nonce, final String encrypt) throws WxAesException {
            try {
                String[] array = new String[] { token, timestamp, nonce, encrypt };
                // 字符串排序
                Arrays.sort(array);

                String data = StringUtils.join(array);
                // SHA1签名生成
                return SHA1.sha1HexUTF8(data);
            } catch (Exception e) {
                throw new WxAesException(AesErrCodes.ComputeSignatureError);
            }
        }
    }

    final static Charset CHARSET = Charset.forName("utf-8");

    final static JaxbHelper<_InXml> inXmlJaxbHelper = new JaxbHelper<>(_InXml.class);

    final static JaxbHelper<_OutXml> outXmlJaxbHelper = new JaxbHelper<>(_OutXml.class);

    public static void main(final String[] args) throws JAXBException, WxAesException {
        // String encodingAesKey =
        // "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
        // String token = "pamtest";
        // String appId = "wxb11529c136998cb6";
        // WxMsgAES aes = new WxMsgAES(token, encodingAesKey, appId);
        String postData = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[jn1L23DB+6ELqJ+6bruv21Y6MD7KeIfP82D6gU39rmkgczbWwt5+3bnyg5K55bgVtVzd832WzZGMhkP72vVOfg==]]></Encrypt></xml>";

        _InXml in = WxMsgAES.inXmlJaxbHelper.unmarshal(postData);

        System.out.println(in);

        String inStr = WxMsgAES.inXmlJaxbHelper.marshal(in);

        System.out.println(inStr);

        in = WxMsgAES.inXmlJaxbHelper.unmarshal(inStr);

        System.out.println(in);

        inStr = WxMsgAES.inXmlJaxbHelper.marshal(in);

        System.out.println(inStr);

    }

    final Base64 base64 = new Base64();
    byte[] aesKey;

    String token;
    String appId;

    /**
     * 构造函数
     *
     * @param token
     *            公众平台上，开发者设置的token
     * @param encodingAesKey
     *            公众平台上，开发者设置的EncodingAESKey
     * @param appId
     *            公众平台appid
     * @throws JAXBException
     *
     * @throws AesException
     *             执行失败，请查看该异常的错误码和具体的错误信息
     */
    public WxMsgAES(final String token, final String encodingAesKey, final String appId) throws WxAesException {
        if (encodingAesKey.length() != 43) {
            throw new WxAesException(AesErrCodes.IllegalAesKey);
        }

        this.token = token;
        this.appId = appId;
        aesKey = Base64.decodeBase64(encodingAesKey + "=");

    }

    /**
     * 对密文进行解密.
     *
     * @param text
     *            需要解密的密文
     * @return 解密得到的明文
     * @throws AesException
     *             aes解密失败
     */
    String decrypt(final String text) throws WxAesException {
        byte[] original;
        try {
            // 设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);

            // 使用BASE64对密文进行解码
            byte[] encrypted = Base64.decodeBase64(text);

            // 解密
            original = cipher.doFinal(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WxAesException(AesErrCodes.DecryptAESError);
        }

        String xmlContent, from_appid;
        try {
            // 去除补位字符
            byte[] bytes = _PKCS7.decode(original);

            // 分离16位随机字符串,网络字节序和AppId
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);

            int xmlLength = recoverNetworkBytesOrder(networkOrder);

            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
            from_appid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WxAesException(AesErrCodes.IllegalBuffer);
        }

        // appid不相同的情况
        if (!from_appid.equals(appId)) {
            throw new WxAesException(AesErrCodes.ValidateAppidError);
        }
        return xmlContent;

    }

    /**
     * 检验消息的真实性，并且获取解密后的明文.
     * <ol>
     * <li>利用收到的密文生成安全签名，进行签名验证</li>
     * <li>若验证通过，则提取xml中的加密消息</li>
     * <li>对消息进行解密</li>
     * </ol>
     *
     * @param msgSignature
     *            签名串，对应URL参数的msg_signature
     * @param timeStamp
     *            时间戳，对应URL参数的timestamp
     * @param nonce
     *            随机串，对应URL参数的nonce
     * @param postData
     *            密文，对应POST请求的数据
     *
     * @return 解密后的原文
     * @throws AesException
     *             执行失败，请查看该异常的错误码和具体的错误信息
     */
    public String decryptMsg(final String msgSignature, final String timeStamp, final String nonce, final String postData) throws WxAesException {

        // 密钥，公众账号的app secret
        // 提取密文
        // Object[] encrypt = XMLParse.extract(postData);
        _InXml _xml;
        try {
            _xml = WxMsgAES.inXmlJaxbHelper.unmarshal(postData);
        } catch (JAXBException e) {
            throw new WxAesException(AesErrCodes.ParseXmlError, null, e);
        }
        if (StringUtils.isNotEmpty(postData) && _xml == null) {
            throw new WxAesException(AesErrCodes.ParseXmlError);
        }

        // 验证安全签名
        String signature = _SHA1.signature(token, timeStamp, nonce, _xml.encrypt);

        // 和URL中的签名比较是否相等
        // System.out.println("第三方收到URL中的签名：" + msg_sign);
        // System.out.println("第三方校验签名：" + signature);
        if (!signature.equals(msgSignature)) {
            throw new WxAesException(AesErrCodes.ValidateSignatureError);
        }

        // 解密
        String result = decrypt(_xml.encrypt);
        return result;
    }

    /**
     * 对明文进行加密.
     *
     * @param text
     *            需要加密的明文
     * @return 加密后base64编码的字符串
     * @throws AesException
     *             aes加密失败
     */
    String encrypt(final String randomStr, final String text) throws WxAesException {
        _ByteGroup byteCollector = new _ByteGroup();
        byte[] randomStrBytes = randomStr.getBytes(CHARSET);
        byte[] textBytes = text.getBytes(CHARSET);
        byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
        byte[] appidBytes = appId.getBytes(CHARSET);

        // randomStr + networkBytesOrder + text + appid
        byteCollector.addBytes(randomStrBytes);
        byteCollector.addBytes(networkBytesOrder);
        byteCollector.addBytes(textBytes);
        byteCollector.addBytes(appidBytes);

        // ... + pad: 使用自定义的填充方式对明文进行补位填充
        byte[] padBytes = _PKCS7.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);

        // 获得最终的字节流, 未加密
        byte[] unencrypted = byteCollector.toBytes();

        try {
            // 设置加密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

            // 加密
            byte[] encrypted = cipher.doFinal(unencrypted);

            // 使用BASE64对加密后的字符串进行编码
            String base64Encrypted = base64.encodeToString(encrypted);

            return base64Encrypted;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WxAesException(AesErrCodes.EncryptAESError);
        }
    }

    /**
     * 将公众平台回复用户的消息加密打包.
     * <ol>
     * <li>对要发送的消息进行AES-CBC加密</li>
     * <li>生成安全签名</li>
     * <li>将消息密文和安全签名打包成xml格式</li>
     * </ol>
     *
     * @param replyMsg
     *            公众平台待回复用户的消息，xml格式的字符串
     * @param timeStamp
     *            时间戳，可以自己生成，也可以用URL参数的timestamp
     * @param nonce
     *            随机串，可以自己生成，也可以用URL参数的nonce
     *
     * @return 加密后的可以直接回复用户的密文，包括msg_signature, timestamp, nonce,
     *         encrypt的xml格式的字符串
     * @throws AesException
     *             执行失败，请查看该异常的错误码和具体的错误信息
     */
    public String encryptMsg(final String replyMsg, String timeStamp, final String nonce) throws WxAesException {
        // 加密
        String encrypt = encrypt(getRandomStr(), replyMsg);

        // 生成安全签名
        if (StringUtils.isEmpty(timeStamp)) {
            timeStamp = Long.toString(System.currentTimeMillis());
        }

        String signature = _SHA1.signature(token, timeStamp, nonce, encrypt);

        // System.out.println("发送给平台的签名是: " + signature[1].toString());
        // 生成发送的xml
        _OutXml out = new _OutXml(signature, encrypt, timeStamp, nonce);

        String result;
        try {
            result = WxMsgAES.outXmlJaxbHelper.marshal(out);
        } catch (JAXBException e) {
            throw new WxAesException(AesErrCodes.ParseXmlError, null, e);
        }

        // String result = XMLParse.generate(encrypt, signature, timeStamp,
        // nonce);
        return result;
    }

    // 生成4个字节的网络字节序
    byte[] getNetworkBytesOrder(final int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte) (sourceNumber & 0xFF);
        orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    // 随机生成16位字符串
    String getRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    // 还原4个字节的网络字节序
    int recoverNetworkBytesOrder(final byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }

    /**
     * 验证URL
     *
     * @param msgSignature
     *            签名串，对应URL参数的msg_signature
     * @param timeStamp
     *            时间戳，对应URL参数的timestamp
     * @param nonce
     *            随机串，对应URL参数的nonce
     * @param echoStr
     *            随机串，对应URL参数的echostr
     *
     * @return 解密之后的echostr
     * @throws AesException
     *             执行失败，请查看该异常的错误码和具体的错误信息
     */
    public String verifyUrl(final String msgSignature, final String timeStamp, final String nonce, final String echoStr) throws WxAesException {
        String signature = _SHA1.signature(token, timeStamp, nonce, echoStr);

        if (!signature.equals(msgSignature)) {
            throw new WxAesException(AesErrCodes.ValidateSignatureError);
        }

        String result = decrypt(echoStr);
        return result;
    }
}
