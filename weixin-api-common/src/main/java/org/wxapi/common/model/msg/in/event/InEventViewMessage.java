package org.wxapi.common.model.msg.in.event;

import org.wxapi.common.model.msg.EventType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 自定义菜单事件。用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报。<br>
 * 点击菜单跳转链接时的事件推送
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         消息类型，event
 * Event           事件类型，VIEW
 * EventKey        事件KEY值，设置的跳转URL
 * </pre>
 *
 * @author xgx
 *
 */
public class InEventViewMessage extends InEventMessage {
    protected String eventKey;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.eventKey = xml.eventKey;
    }

    @Override
    public EventType defaultEventType() {
        return EventType.VIEW;
    }

    public String getEventKey() {
        return eventKey;
    }

}
