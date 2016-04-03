package org.wxapi.common.codec.aes;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableMap;

/**
 * 公众平台消息体使用签名及加解密方案时的函数错误返回码
 *
 * @author xgx
 * @see http://mp.weixin.qq.com/wiki/0/61c3a8b9d50ac74f18bdf2e54ddfc4e0.html
 */
public class AesErrCodes {

    /**
     * 0: 请求成功
     */
    public final static int SUCCESS = 0;

    public final static int ValidateSignatureError = -40001;
    public final static int ParseXmlError = -40002;
    public final static int ComputeSignatureError = -40003;
    public final static int IllegalAesKey = -40004;
    public final static int ValidateAppidError = -40005;
    public final static int EncryptAESError = -40006;
    public final static int DecryptAESError = -40007;
    public final static int IllegalBuffer = -40008;
    public final static int EncBase64Error = -40009;
    public final static int DecBase64Error = -40010;
    public final static int MPGenXmlAckError = -40011;

    /**
     * 包含所有公众平台消息体使用签名及加解密方案时的函数错误返回码的ImmutableMap
     */
    public final static Map<Integer, String> ALL_CODES = ImmutableMap.copyOf(new HashMap<Integer, String>() {
        private static final long serialVersionUID = 8342759338490235957L;
        {
            put(0, "处理成功");
            put(ValidateSignatureError, "校验签名失败");
            put(ParseXmlError, "解析xml失败");
            put(ComputeSignatureError, "计算签名失败");
            put(IllegalAesKey, "不合法的AESKey");
            put(ValidateAppidError, "校验AppID失败");
            put(EncryptAESError, "AES加密失败");
            put(DecryptAESError, "AES解密失败");
            put(IllegalBuffer, "公众平台发送的xml不合法");
            put(EncBase64Error, "Base64编码失败");
            put(DecBase64Error, "Base64解码失败");
            put(MPGenXmlAckError, "公众帐号生成回包xml失败");
        }
    });

    /**
     * 根据返回值代码获得相应的错误提示消息
     *
     * @param code
     *            接口返回值代码
     * @return 错误提示消息
     */
    public final static String fromCode(final int code) {
        return ALL_CODES.get(code);
    }

    /**
     * 根据返回值代码判断处理是否成功
     *
     * @param code
     *            接口返回值代码
     * @return true/false
     */
    public final static boolean isSuccessful(final int code) {
        return code == SUCCESS;
    }

    public final static String notEmptyOrFromCode(final String message, final int code) {
        return StringUtils.isNotEmpty(message) ? message : fromCode(code);
    }
}
