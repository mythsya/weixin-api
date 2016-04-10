package org.wxapi.common.model.msg.out;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxapi.common.model.XmlSerializable;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.util.AdapterCDATA;

/**
 * 被动回复消息的基类
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
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class BaseOutMessage implements XmlSerializable {

    @XmlElement(name = "ToUserName", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String toUserName;

    @XmlElement(name = "FromUserName", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String fromUserName;

    @XmlElement(name = "CreateTime", nillable = false, required = true)
    protected long createTime;

    @XmlElement(name = "MsgType", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String msgType;

    public long getCreateTime() {
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

    public void setCreateTime(final long createTime) {
        this.createTime = createTime;
    }

    public void setFromUserName(final String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public void setMsgType(final MessageType msgType) {
        this.msgType = msgType.getCode();
    }

    public void setToUserName(final String toUserName) {
        this.toUserName = toUserName;
    }
}
