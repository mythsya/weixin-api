package org.wxapi.common.model.msg.in;

import org.wxapi.common.model.msg.MessageType;

/**
 * 普通消息、事件消息的基类
 *
 * <pre>
 *  <xml>
 *      <ToUserName><![CDATA[toUser]]></ToUserName>
 *      <FromUserName><![CDATA[fromUser]]></FromUserName>
 *      <CreateTime>1348831860</CreateTime>
 *      <MsgType><![CDATA[text]]></MsgType>
 *      ...
 *   </xml>
 * </pre>
 *
 * @author xgx
 *
 */
public abstract class BaseInMessage {

    protected String toUserName;

    protected String fromUserName;

    protected String createTime;

    protected String msgType;

    public void copyFrom(final GenericXmlInMessage xml) {
        this.fromUserName = xml.fromUserName;
        this.toUserName = xml.toUserName;
        this.createTime = xml.createTime;
        this.msgType = xml.msgType;
    }

    public abstract MessageType defaultMessageType();

    public String getCreateTime() {
        return createTime;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public MessageType getMsgType() {
        return MessageType.fromCode(msgType);
    }

    public String getToUserName() {
        return toUserName;
    }

}
