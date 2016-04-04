package org.wxapi.common.model.msg.in.event;

import org.apache.commons.lang3.StringUtils;
import org.wxapi.common.model.msg.EventType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 用户在关注公众号时,微信会把这个事件推送到开发者填写的URL，方便开发者给用户下发欢迎消息；<br>
 * 或者用户扫描带场景值二维码时，如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。<br>
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         消息类型，event
 * Event           事件类型，subscribe
 * EventKey        事件KEY值，qrscene_为前缀，后面为二维码的参数值 (用户主动关注公众号时为空)
 * Ticket          二维码的ticket，可用来换取二维码图片 (用户主动关注公众号时为空)
 * </pre>
 *
 * @author xgx
 *
 */
public class InEventSubscribeMessage extends InEventMessage {
    protected String eventKey;
    protected String ticket;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.eventKey = xml.eventKey;
        this.ticket = xml.ticket;
    }

    @Override
    public EventType defaultEventType() {
        return EventType.SUBSCRIBE;
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public boolean isScanEvent() {
        return StringUtils.isNotEmpty(eventKey) && StringUtils.isNotEmpty(ticket);
    }

}
