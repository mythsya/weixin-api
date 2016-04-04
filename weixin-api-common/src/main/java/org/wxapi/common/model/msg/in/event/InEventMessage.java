package org.wxapi.common.model.msg.in.event;

import org.wxapi.common.model.msg.EventType;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.BaseInMessage;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 在微信用户和公众号产生交互的过程中，用户的某些操作会使得微信服务器通过事件推送的形式通知到开发者在开发者中心处设置的服务器地址，从而开发者可以获取到该信息
 * 。其中，某些事件推送在发生后，是允许开发者回复用户的，某些则不允许。
 *
 * @author xgx
 * @see http://mp.weixin.qq.com/wiki/2/5baf56ce4947d35003b86a9805634b1e.html
 */
public abstract class InEventMessage extends BaseInMessage {

    protected String event;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.event = xml.event;
    }

    public abstract EventType defaultEventType();

    @Override
    public MessageType defaultMessageType() {
        return MessageType.EVENT;
    }

    public EventType getEvent() {
        return EventType.fromCode(event);
    }
}
