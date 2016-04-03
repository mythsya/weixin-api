package org.wxapi.common.model.menu;

/**
 *
 * @author xgx
 *
 */
public enum MenuButtonCategory {

    CLICK(1), VIEW(2), MEDIA(3);

    public static MenuButtonCategory fromCode(final int v) {
        for (MenuButtonCategory g : MenuButtonCategory.values()) {
            if (g.getCode() == v) {
                return g;
            }
        }
        return null;
    }

    int code;

    MenuButtonCategory(final int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
