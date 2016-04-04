package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 小视频消息
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         小视频为shortvideo
 * MediaId         视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
 * ThumbMediaId    视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
 * MsgId           消息id，64位整型
 * </pre>
 *
 * @author xgx
 *
 */
public class InNormalShortVideoMessage extends InNormalMessage {
    protected String mediaId;
    protected String thumbMediaId;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.mediaId = xml.mediaId;
        this.thumbMediaId = xml.thumbMediaId;
    }

    @Override
    public MessageType defaultMessageType() {
        return MessageType.SHORTVIDEO;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

}
