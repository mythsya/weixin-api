package org.wxapi.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 错误时微信会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:<br>
 * {"errcode":40013,"errmsg":"invalid appid"}
 *
 * @author xgx
 *
 */
public class ErrResponse implements JsonSerializable {

    private String errCode;
    private String errMsg;

    public ErrResponse() {
    }

    public ErrResponse(final String errCode, final String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @JsonProperty("errcode")
    public String getErrCode() {
        return errCode;
    }

    @JsonProperty("errmsg")
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrCode(final String errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(final String errMsg) {
        this.errMsg = errMsg;
    }

}
