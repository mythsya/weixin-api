package org.wxapi.common.model.token;

import java.util.concurrent.locks.ReentrantLock;

import org.wxapi.common.model.JsonSerializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。
 * access_token的存储至少要保留512个字符空间。access_token的有效期目前为2个小时，需定时刷新，
 * 重复获取将导致上次获取的access_token失效。
 *
 * @author xgx
 *
 */
public class AccessToken implements JsonSerializable {
    protected final static int expiresOffset = 60 * 1000; // in milliseconds
    protected volatile String accessToken = null;
    protected volatile String previousAccessToken = null;
    protected volatile int expiresIn = 7200;
    protected volatile long activeFrom = -1;// in milliseconds
    protected volatile long activeTill = -1;// in milliseconds
    protected final ReentrantLock lock = new ReentrantLock();

    public AccessToken() {

    }

    public AccessToken(final String accessToken, final int expiresIn) {
        this(accessToken, expiresIn, System.currentTimeMillis());
    }

    public AccessToken(final String accessToken, final int expiresIn, final long activeFrom) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.activeFrom = activeFrom;
        this.activeTill = activeFrom + expiresIn * 1000 - expiresOffset;
    }

    /**
     * 获取到的凭证
     *
     * @return
     */
    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonIgnore
    public long getActiveFrom() {
        return activeFrom;
    }

    @JsonIgnore
    public long getActiveTill() {
        return activeTill;
    }

    /**
     * 凭证有效时间，单位：秒
     *
     * @return
     */
    @JsonProperty("expires_in")
    public int getExpiresIn() {
        return expiresIn;
    }

    @JsonIgnore
    public String getPreviousAccessToken() {
        return previousAccessToken;
    }

    @JsonIgnore
    public boolean isExpired() {
        lock.lock();
        try {
            if (this.activeTill > 0) {
                return System.currentTimeMillis() >= this.activeTill;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void resetAccessToken(final String accessToken, final int expiresIn) {
        resetAccessToken(accessToken, expiresIn, System.currentTimeMillis());
    }

    public void resetAccessToken(final String accessToken, final int expiresIn, final long activeFrom) {
        lock.lock();
        try {
            this.previousAccessToken = this.accessToken;
            this.accessToken = accessToken;
            this.expiresIn = expiresIn;
            this.activeFrom = activeFrom;
            this.activeTill = activeFrom + expiresIn * 1000 - expiresOffset;
        } finally {
            lock.unlock();
        }
    }

    public void resetActivePeriod(final long activeFrom) {
        lock.lock();
        try {
            this.activeFrom = activeFrom;
            this.activeTill = activeFrom + expiresIn * 1000 - expiresOffset;
        } finally {
            lock.unlock();
        }
    }

    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresIn(final int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
