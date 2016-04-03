package org.wxapi.common.api;

import java.util.Map;

/**
 *
 * @author xgx
 *
 */
public class WebApi {

    static enum HttpMethod {
        GET, POST, DELETE, PUT
    }

    static enum HttpProtocol {
        HTTP, HTTPS
    }

    private HttpProtocol protocol = HttpProtocol.HTTPS;

    private HttpMethod method = HttpMethod.POST;

    private String url;

    private Map<String, Object> parameters;

    public WebApi() {
    }

    public WebApi(final HttpProtocol protocol, final HttpMethod method, final String url) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
    }

    public WebApi(final HttpProtocol protocol, final HttpMethod method, final String url, final Map<String, Object> params) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.parameters = params;
    }

    public WebApi(final String url) {
        this.url = url;
    }

    public WebApi(final String url, final Map<String, Object> params) {
        this.url = url;
        this.parameters = params;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public HttpProtocol getProtocol() {
        return protocol;
    }

    public String getUrl() {
        return url;
    }

    public void setMethod(final HttpMethod method) {
        this.method = method;
    }

    public void setParameters(final Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public void setProtocol(final HttpProtocol protocol) {
        this.protocol = protocol;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
