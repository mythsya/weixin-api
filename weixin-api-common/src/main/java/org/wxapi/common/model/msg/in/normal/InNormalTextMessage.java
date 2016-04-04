package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 文本消息
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         text
 * Content         文本消息内容
 * MsgId           消息id，64位整型
 * </pre>
 *
 * @author xgx
 *
 */
public class InNormalTextMessage extends InNormalMessage {
    protected String content;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.content = xml.content;
    }

    @Override
    public MessageType defaultMessageType() {
        return MessageType.TEXT;
    }

    public String getContent() {
        return content;
    }
}
