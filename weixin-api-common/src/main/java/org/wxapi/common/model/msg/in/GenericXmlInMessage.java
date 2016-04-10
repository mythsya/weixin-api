package org.wxapi.common.model.msg.in;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxapi.common.model.XmlSerializable;
import org.wxapi.common.model.msg.EventType;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.util.AdapterCDATA;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class GenericXmlInMessage implements XmlSerializable {

    @XmlElement(name = "ToUserName", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String toUserName;

    @XmlElement(name = "FromUserName", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String fromUserName;

    @XmlElement(name = "CreateTime", nillable = false, required = true)
    public long createTime;

    @XmlElement(name = "MsgType", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String msgType;

    @XmlElement(name = "MsgId")
    public String msgId;

    @XmlElement(name = "Event")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String event;

    @XmlElement(name = "Content")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String content;

    @XmlElement(name = "PicUrl")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String picUrl;

    @XmlElement(name = "MediaId")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String mediaId;

    @XmlElement(name = "Format")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String format;

    @XmlElement(name = "Recognition")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String recognition;

    @XmlElement(name = "ThumbMediaId")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String thumbMediaId;

    @XmlElement(name = "Location_X")
    public String locationX;

    @XmlElement(name = "Location_Y")
    public String locationY;

    @XmlElement(name = "Scale")
    public String scale;

    @XmlElement(name = "Label")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String label;

    @XmlElement(name = "Title")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String title;

    @XmlElement(name = "Description")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String description;

    @XmlElement(name = "Url")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String url;

    @XmlElement(name = "EventKey")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String eventKey;

    @XmlElement(name = "Ticket")
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    public String ticket;

    @XmlElement(name = "Latitude")
    public String latitude;

    @XmlElement(name = "Longitude")
    public String longitude;

    @XmlElement(name = "Precision")
    public String precision;

    public EventType getEvtType() {
        return EventType.fromCode(event);
    }

    public MessageType getMsgType() {
        return MessageType.fromCode(msgType);
    }
}
