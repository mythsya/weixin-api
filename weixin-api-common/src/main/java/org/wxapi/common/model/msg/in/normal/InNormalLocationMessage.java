package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 地理位置消息
 *
 * <pre>
 * 参数             描述
 * ToUserName      开发者微信号
 * FromUserName    发送方帐号（一个OpenID）
 * CreateTime      消息创建时间 （整型）
 * MsgType         location
 * Location_X      地理位置维度
 * Location_Y      地理位置经度
 * Scale           地图缩放大小
 * Label           地理位置信息
 * MsgId           消息id，64位整型
 * </pre>
 *
 * @author xgx
 *
 */
public class InNormalLocationMessage extends InNormalMessage {
    protected String locationX;
    protected String locationY;
    protected String scale;
    protected String label;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.locationX = xml.locationX;
        this.locationY = xml.locationY;
        this.scale = xml.scale;
        this.label = xml.label;
    }

    @Override
    public MessageType defaultMessageType() {
        return MessageType.LOCATION;
    }

    public String getLabel() {
        return label;
    }

    public String getLocationX() {
        return locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public String getScale() {
        return scale;
    }

}
