package org.wxapi.common.model.msg.in.event;

import org.wxapi.common.model.msg.EventType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 上报地理位置事件<br>
 * 用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置，公众号可以在公众平台网站中修改以上设置。
 * 上报地理位置时，微信会将上报地理位置事件推送到开发者填写的URL。
 *
 * <pre>
 * 参数            描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         消息类型，event
 * Event           事件类型，LOCATION
 * Latitude        地理位置纬度
 * Longitude       地理位置经度
 * Precision       地理位置精度
 * </pre>
 *
 * @author xgx
 *
 */
public class InEventLocationMessage extends InEventMessage {
    protected String latitude;
    protected String longitude;
    protected String precision;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.latitude = xml.latitude;
        this.longitude = xml.longitude;
        this.precision = xml.precision;
    }

    @Override
    public EventType defaultEventType() {
        return EventType.LOCATION;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getPrecision() {
        return precision;
    }
}
