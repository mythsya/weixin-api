package org.wxapi.common.model.msg.out.reply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxapi.common.model.XmlSerializable;
import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.AdapterCDATA;

/**
 * 回复图片消息
 *
 * <pre>
 * &lt;xml>
 *   &lt;ToUserName>&lt;![CDATA[toUser]]>&lt;/ToUserName>
 *   &lt;FromUserName>&lt;![CDATA[fromUser]]>&lt;/FromUserName>
 *   &lt;CreateTime>12345678&lt;/CreateTime>
 *   &lt;MsgType>&lt;![CDATA[image]]>&lt;/MsgType>
 *   &lt;Image>
 *     &lt;MediaId>&lt;![CDATA[media_id]]>&lt;/MediaId>
 *   &lt;/Image>
 * &lt;/xml>
 * </pre>
 *
 * <pre>
 * 参数            是否必须    描述
 * ToUserName      是        接收方帐号（收到的OpenID）
 * FromUserName    是        开发者微信号
 * CreateTime      是        消息创建时间 （整型）
 * MsgType         是        image
 * MediaId         是        通过素材管理接口上传多媒体文件，得到的id。
 * </pre>
 *
 * @author xgx
 *
 */
@XmlRootElement(name = "xml")
public class OutReplyImageMessage extends BaseOutMessage {

    @XmlAccessorType(XmlAccessType.NONE)
    @XmlType(name = "image")
    public static class Image implements XmlSerializable {

        @XmlElement(name = "MediaId", nillable = false, required = true)
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(final String mediaId) {
            this.mediaId = mediaId;
        }

    }

    @XmlElement(name = "Image", type = Image.class)
    protected Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(final Image image) {
        this.image = image;
    }
}
