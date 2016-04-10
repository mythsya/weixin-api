package org.wxapi.common.model.msg.out.reply;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.AdapterCDATA;

/**
 * 回复文本消息
 *
 * <pre>
 * &lt;xml>
 *   &lt;ToUserName>&lt;![CDATA[toUser]]>&lt;/ToUserName>
 *   &lt;FromUserName>&lt;![CDATA[fromUser]]>&lt;/FromUserName>
 *   &lt;CreateTime>12345678&lt;/CreateTime>
 *   &lt;MsgType>&lt;![CDATA[text]]>&lt;/MsgType>
 *   &lt;Content>&lt;![CDATA[你好]]>&lt;/Content>
 * &lt;/xml>
 * </pre>
 *
 * <pre>
 * 参数            是否必须    描述
 * ToUserName      是        接收方帐号（收到的OpenID）
 * FromUserName    是        开发者微信号
 * CreateTime      是        消息创建时间 （整型）
 * MsgType         是        text
 * Content         是        回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
 * </pre>
 *
 * @author xgx
 *
 */
@XmlRootElement(name = "xml")
public class OutReplyTextMessage extends BaseOutMessage {

    @XmlElement(name = "Content", nillable = false, required = true)
    @XmlJavaTypeAdapter(AdapterCDATA.class)
    protected String content;

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

}
