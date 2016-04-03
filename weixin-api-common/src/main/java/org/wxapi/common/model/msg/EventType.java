package org.wxapi.common.model.msg;

/**
 * 用户操作引发的事件推送中的事件类型
 * 
 * @author xgx
 *
 */
public enum EventType {

    SUBSCRIBE("subscribe", "关注事件"),

    UNSUBSCRIBE("unsubscribe", "取消关注事件"),

    SCAN("SCAN", "扫描带参数二维码事件"),

    LOCATION("LOCATION", "上报地理位置事件"),

    CLICK("CLICK", "点击菜单拉取消息时的事件推送"),

    VIEW("VIEW", "点击菜单跳转链接时的事件推送");

    public static EventType fromCode(final String v) {
        for (EventType g : EventType.values()) {
            if (g.getCode().equals(v)) {
                return g;
            }
        }
        return null;
    }

    String code;

    String name;

    EventType(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
