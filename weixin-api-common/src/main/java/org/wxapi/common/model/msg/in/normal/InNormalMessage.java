package org.wxapi.common.model.msg.in.normal;

import org.wxapi.common.model.msg.in.BaseInMessage;
import org.wxapi.common.model.msg.in.GenericXmlInMessage;

/**
 * 接收的普通消息。​当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
 * <ol>
 * <li>关于重试的消息排重，推荐使用msgid排重。</li>
 * <li>微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次。假如服务器无法保证在五秒内处理并回复，可以直接回复空串，
 * 微信服务器不会对此作任何处理，并且不会发起重试。详情请见“发送消息-被动回复消息”。</li>
 * <li>为了保证更高的安全保障，开发者可以在公众平台官网的开发者中心处设置消息加密。开启加密后，用户发来的消息会被加密，
 * 公众号被动回复用户的消息也需要加密（ 但开发者通过客服接口等API调用形式向用户发送消息，则不受影响）。关于消息加解密的详细说明，请见“消息加解密说明”。
 * </li>
 * </ol>
 *
 * @author xgx
 * @see http://mp.weixin.qq.com/wiki/10/79502792eef98d6e0c6e1739da387346.html
 */
public abstract class InNormalMessage extends BaseInMessage {

    protected String msgId;

    @Override
    public void copyFrom(final GenericXmlInMessage xml) {
        super.copyFrom(xml);
        this.msgId = xml.msgId;
    }

    public String getMsgId() {
        return msgId;
    }

}
