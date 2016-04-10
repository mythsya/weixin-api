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
 * 回复视频消息
 *
 * <pre>
 * &lt;xml>
 *   &lt;ToUserName>&lt;![CDATA[toUser]]>&lt;/ToUserName>
 *   &lt;FromUserName>&lt;![CDATA[fromUser]]>&lt;/FromUserName>
 *   &lt;CreateTime>12345678&lt;/CreateTime>
 *   &lt;MsgType>&lt;![CDATA[video]]>&lt;/MsgType>
 *   &lt;Video>
 *     &lt;MediaId>&lt;![CDATA[media_id]]>&lt;/MediaId>
 *     &lt;Title>&lt;![CDATA[title]]>&lt;/Title>
 *     &lt;Description>&lt;![CDATA[description]]>&lt;/Description>
 *   &lt;/Video>
 * &lt;/xml>
 * </pre>
 *
 * <pre>
 * 参数            是否必须    描述
 * ToUserName      是        接收方帐号（收到的OpenID）
 * FromUserName    是        开发者微信号
 * CreateTime      是        消息创建时间 （整型）
 * MsgType         是        video
 * MediaId         是        通过素材管理接口上传多媒体文件，得到的id
 * Title           否        视频消息的标题
 * Description     否        视频消息的描述
 * </pre>
 *
 * @author xgx
 *
 */
@XmlRootElement(name = "xml")
public class OutReplyVideoMessage extends BaseOutMessage {

    @XmlAccessorType(XmlAccessType.NONE)
    @XmlType(name = "video")
    public static class Video implements XmlSerializable {

        @XmlElement(name = "MediaId", nillable = false, required = true)
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String mediaId;

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String title;

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String description;

        public String getDescription() {
            return description;
        }

        public String getMediaId() {
            return mediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(final String description) {
            this.description = description;
        }

        public void setMediaId(final String mediaId) {
            this.mediaId = mediaId;
        }

        public void setTitle(final String title) {
            this.title = title;
        }

    }

    @XmlElement(name = "Video", type = Video.class)
    protected Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(final Video video) {
        this.video = video;
    }

}
