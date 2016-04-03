package org.wxapi.common.codetable;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)
 *
 * @author xgx
 *
 */
public enum PlatformType {
    IOS(1), ANDROID(2), OTHERS(3);

    public static PlatformType fromCode(final int v) {
        for (PlatformType g : PlatformType.values()) {
            if (g.getCode() == v) {
                return g;
            }
        }
        return null;
    }

    int code;

    PlatformType(final int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return this.code;
    }
}
