package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 语音消息
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         语音为voice
 * MediaId         语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
 * Format          语音格式，如amr，speex等
 * MsgID           消息id，64位整型
 * </pre>
 *
 * @author xgx
 *
 */
public class InNormalVoiceMessage extends InNormalMessage {
    protected String mediaId;
    protected String format;
    protected String recognition;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.mediaId = xml.mediaId;
        this.format = xml.format;
        this.recognition = xml.recognition;
    }

    @Override
    public MessageType defaultMessageType() {
        return MessageType.VOICE;
    }

    public String getFormat() {
        return format;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getRecognition() {
        return recognition;
    }

}
