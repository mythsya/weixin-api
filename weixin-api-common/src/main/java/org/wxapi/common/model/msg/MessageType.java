package org.wxapi.common.model.msg;

/**
 * 消息类型，包括：接收的普通消息、事件推送，及被动回复的消息
 * 
 * @author xgx
 *
 */
public enum MessageType {

    TEXT("text", "文本消息"),

    IMAGE("image", "图片消息"),

    VOICE("voice", "语音消息"),

    VIDEO("video", "视频消息"),

    SHORTVIDEO("shortvideo", "小视频消息"),

    LOCATION("location", "地理位置消息"),

    LINK("link", "链接消息"),

    EVENT("event", "事件推送"),

    MUSIC("music", "音乐消息"),

    NEWS("news", "图文消息");

    public static MessageType fromCode(final String v) {
        for (MessageType g : MessageType.values()) {
            if (g.getCode().equals(v)) {
                return g;
            }
        }
        return null;
    }

    String code;

    String name;

    MessageType(final String code, final String name) {
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
