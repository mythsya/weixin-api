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
 * 回复音乐消息
 *
 * <pre>
 * &lt;xml>
 *   &lt;ToUserName>&lt;![CDATA[toUser]]>&lt;/ToUserName>
 *   &lt;FromUserName>&lt;![CDATA[fromUser]]>&lt;/FromUserName>
 *   &lt;CreateTime>12345678&lt;/CreateTime>
 *   &lt;MsgType>&lt;![CDATA[music]]>&lt;/MsgType>
 *   &lt;Music>
 *     &lt;Title>&lt;![CDATA[TITLE]]>&lt;/Title>
 *     &lt;Description>&lt;![CDATA[DESCRIPTION]]>&lt;/Description>
 *     &lt;MusicUrl>&lt;![CDATA[MUSIC_Url]]>&lt;/MusicUrl>
 *     &lt;HQMusicUrl>&lt;![CDATA[HQ_MUSIC_Url]]>&lt;/HQMusicUrl>
 *     &lt;ThumbMediaId>&lt;![CDATA[media_id]]>&lt;/ThumbMediaId>
 *   &lt;/Music>
 * &lt;/xml>
 * </pre>
 *
 * <pre>
 * 参数            是否必须    描述
 * ToUserName      是        接收方帐号（收到的OpenID）
 * FromUserName    是        开发者微信号
 * CreateTime      是        消息创建时间 （整型）
 * MsgType         是        music
 * Title           否        音乐标题
 * Description     否        音乐描述
 * MusicUrl        否        音乐链接
 * HQMusicUrl      否        高质量音乐链接，WIFI环境优先使用该链接播放音乐
 * ThumbMediaId    否        缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
 * </pre>
 *
 * @author xgx
 *
 */
@XmlRootElement(name = "xml")
public class OutReplyMusicMessage extends BaseOutMessage {

    @XmlAccessorType(XmlAccessType.NONE)
    @XmlType(name = "music")
    public static class Music implements XmlSerializable {

        @XmlElement(name = "ThumbMediaId")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String thumbMediaId;

        @XmlElement(name = "MusicUrl")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String musicUrl;

        @XmlElement(name = "HQMusicUrl")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String hqMusicUrl;

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String title;

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String description;

        public String getDescription() {
            return description;
        }

        public String getHqMusicUrl() {
            return hqMusicUrl;
        }

        public String getMusicUrl() {
            return musicUrl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(final String description) {
            this.description = description;
        }

        public void setHqMusicUrl(final String hqMusicUrl) {
            this.hqMusicUrl = hqMusicUrl;
        }

        public void setMusicUrl(final String musicUrl) {
            this.musicUrl = musicUrl;
        }

        public void setThumbMediaId(final String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public void setTitle(final String title) {
            this.title = title;
        }

    }

    @XmlElement(name = "Music", type = Music.class)
    protected Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(final Music music) {
        this.music = music;
    }
}
