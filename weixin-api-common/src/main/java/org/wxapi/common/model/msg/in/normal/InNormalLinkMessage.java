package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 链接消息
 *
 * <pre>
 * 参数            描述
 * ToUserName      接收方微信号
 * FromUserName    发送方微信号，若为普通用户，则是一个OpenID
 * CreateTime      消息创建时间
 * MsgType         消息类型，link
 * Title           消息标题
 * Description     消息描述
 * Url             消息链接
 * MsgId           消息id，64位整型
 * </pre>
 *
 * @author xgx
 *
 */
public class InNormalLinkMessage extends InNormalMessage {
    protected String title;
    protected String description;
    protected String url;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.title = xml.title;
        this.description = xml.description;
        this.url = xml.url;
    }

    @Override
    public MessageType defaultMessageType() {
        return MessageType.LINK;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

}
