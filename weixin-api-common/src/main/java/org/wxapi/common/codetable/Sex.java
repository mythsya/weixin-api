package org.wxapi.common.codetable;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 性别：男（1）女（2）
 *
 * @author xgx
 *
 */
public enum Sex {
    MALE(1), FEMALE(2);

    public static Sex fromCode(final int v) {
        for (Sex g : Sex.values()) {
            if (g.getCode() == v) {
                return g;
            }
        }
        return null;
    }

    int code;

    Sex(final int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return this.code;
    }
}
