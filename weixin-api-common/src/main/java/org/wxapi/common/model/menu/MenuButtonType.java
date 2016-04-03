package org.wxapi.common.model.menu;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 自定义菜单接口可实现多种类型按钮，如下：<br>
 *
 * <pre>
 * 1、click：点击推事件
 * 2、view：跳转URL
 * 3、scancode_push：扫码推事件
 * 4、scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框
 * 5、pic_sysphoto：弹出系统拍照发图
 * 6、pic_photo_or_album：弹出拍照或者相册发图
 * 7、pic_weixin：弹出微信相册发图器
 * 8、location_select：弹出地理位置选择器
 * 9、media_id：下发消息（除文本消息）
 * 10、view_limited：跳转图文消息URL<br>
 * </pre>
 *
 * @author xgx
 *
 */
public enum MenuButtonType {

    CLICK("click", "点击推事件", MenuButtonCategory.CLICK),

    VIEW("view", "跳转URL", MenuButtonCategory.VIEW),

    SCANCODE_PUSH("scancode_push", "扫码推事件", MenuButtonCategory.CLICK),

    SCANCODE_WAITMSG("scancode_waitmsg", "扫码推事件且弹出“消息接收中”提示框", MenuButtonCategory.CLICK),

    PIC_SYSPHOTO("pic_sysphoto", "弹出系统拍照发图", MenuButtonCategory.CLICK),

    PIC_PHOTO_OR_ALBUM("pic_photo_or_album", "弹出拍照或者相册发图", MenuButtonCategory.CLICK),

    PIC_WEIXIN("pic_weixin", "弹出微信相册发图器", MenuButtonCategory.CLICK),

    LOCATION_SELECT("location_select", "弹出地理位置选择器", MenuButtonCategory.CLICK),

    MEDIA_ID("media_id", "下发消息（除文本消息）", MenuButtonCategory.MEDIA),

    VIEW_LIMITED("view_limited", "跳转图文消息URL", MenuButtonCategory.MEDIA);

    public static MenuButtonType fromCode(final String v) {
        for (MenuButtonType g : MenuButtonType.values()) {
            if (g.getCode().equalsIgnoreCase(v)) {
                return g;
            }
        }
        return null;
    }

    String code;

    String name;

    MenuButtonCategory category;

    MenuButtonType(final String code, final String name, final MenuButtonCategory category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    public MenuButtonCategory getCategory() {
        return this.category;
    }

    @JsonValue
    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name();
    }
}
