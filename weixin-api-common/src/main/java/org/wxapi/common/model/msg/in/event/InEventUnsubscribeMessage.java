package org.wxapi.common.model.msg.in.event;

import org.wxapi.common.model.msg.EventType;

/**
 * 用户在取消关注公众号时，微信会把这个事件推送到开发者填写的URL，方便开发者给用户做帐号的解绑。
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         消息类型，event
 * Event           事件类型，unsubscribe(取消订阅)
 * </pre>
 *
 * @author xgx
 *
 */
public class InEventUnsubscribeMessage extends InEventMessage {
    @Override
    public EventType defaultEventType() {
        return EventType.UNSUBSCRIBE;
    }
}
