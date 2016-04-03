package org.wxapi.common.codec.aes;

import org.wxapi.common.WeixinException;

/**
 *
 * @author xgx
 *
 */
public class WxAesException extends WeixinException {

    private static final long serialVersionUID = -4728503518328428073L;

    public WxAesException(final int code) {
        super(code, AesErrCodes.fromCode(code));
    }

    public WxAesException(final int code, final String message) {
        super(code, message);
    }

    public WxAesException(final int code, final String message, final Throwable cause) {
        super(code, message, cause);
    }
}
