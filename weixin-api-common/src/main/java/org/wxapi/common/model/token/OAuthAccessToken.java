package org.wxapi.common.model.token;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信网页授权是通过OAuth2.0机制实现的，在用户授权给公众号后，公众号可以获取到一个网页授权特有的接口调用凭证（网页授权access_token），
 * 通过网页授权access_token可以进行授权后接口调用，如获取用户基本信息
 *
 * @author xgx
 *
 */
public class OAuthAccessToken extends AccessToken {
    private volatile String refreshToken;
    private volatile String openid;
    private volatile String scope;
    private volatile String unionid;

    public OAuthAccessToken() {
        super();
    }

    public OAuthAccessToken(final String accessToken, final int expiresIn, final String refreshToken, final String openid, final String scope, final String unionid) {
        this(accessToken, expiresIn, refreshToken, openid, scope, unionid, System.currentTimeMillis());
    }

    public OAuthAccessToken(final String accessToken, final int expiresIn, final String refreshToken, final String openid, final String scope, final String unionid, final long activeFrom) {
        super(accessToken, expiresIn, activeFrom);
        this.refreshToken = refreshToken;
        this.openid = openid;
        this.scope = scope;
        this.unionid = unionid;
    }

    @JsonProperty("openid")
    public String getOpenid() {
        return openid;
    }

    @JsonProperty("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    @JsonProperty("unionid")
    public String getUnionid() {
        return unionid;
    }

    public void setOpenid(final String openid) {
        this.openid = openid;
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setScope(final String scope) {
        this.scope = scope;
    }

    public void setUnionid(final String unionid) {
        this.unionid = unionid;
    }

}
