package org.wxapi.common.model.msg.in.event;

import org.wxapi.common.model.msg.EventType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 用户扫描带场景值二维码时，可能推送以下两种事件：<br>
 * <br>
 * 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。<br>
 * 如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。<br>
 * <br>
 * <b>用户已关注时的事件推送</b>
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         消息类型，event
 * Event           事件类型，SCAN
 * EventKey        事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
 * Ticket          二维码的ticket，可用来换取二维码图片
 * </pre>
 *
 * @author xgx
 *
 */
public class InEventScanMessage extends InEventMessage {
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
        return EventType.SCAN;
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getTicket() {
        return ticket;
    }

}
