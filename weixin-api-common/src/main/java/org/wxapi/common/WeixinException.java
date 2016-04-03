package org.wxapi.common;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author xgx
 *
 */
public class WeixinException extends Exception {

    private static final long serialVersionUID = 5439923317736640109L;

    protected final int errCode;

    protected final String errMessage;

    @SuppressWarnings("unchecked")
    public WeixinException(final int code) {
        super(StringUtils.join(code, ":", GlobalErrCodes.fromCode(code)));
        this.errCode = code;
        this.errMessage = GlobalErrCodes.fromCode(code);
    }

    @SuppressWarnings("unchecked")
    public WeixinException(final int code, final String message) {
        super(StringUtils.join(code, ":", GlobalErrCodes.notEmptyOrFromCode(message, code)));
        this.errCode = code;
        this.errMessage = GlobalErrCodes.notEmptyOrFromCode(message, code);
    }

    @SuppressWarnings("unchecked")
    public WeixinException(final int code, final String message, final Throwable cause) {
        super(StringUtils.join(code, ":", GlobalErrCodes.notEmptyOrFromCode(message, code)), cause);
        this.errCode = code;
        this.errMessage = GlobalErrCodes.notEmptyOrFromCode(message, code);
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

}
