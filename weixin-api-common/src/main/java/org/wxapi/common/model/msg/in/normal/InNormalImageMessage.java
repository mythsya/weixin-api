package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 图片消息
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         image
 * PicUrl          图片链接
 * MediaId         图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
 * MsgId           消息id，64位整型
 * </pre>
 *
 * @author xgx
 *
 */
public class InNormalImageMessage extends InNormalMessage {
    protected String picUrl;
    protected String mediaId;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.picUrl = xml.picUrl;
        this.mediaId = xml.mediaId;
    }

    @Override
    public MessageType defaultMessageType() {
        return MessageType.IMAGE;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

}
