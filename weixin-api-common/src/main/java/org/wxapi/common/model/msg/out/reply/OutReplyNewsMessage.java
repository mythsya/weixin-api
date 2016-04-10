package org.wxapi.common.model.msg.out.reply;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.wxapi.common.model.XmlSerializable;
import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.AdapterCDATA;

/**
 * 回复图文消息
 *
 * <pre>
 * &lt;xml>
 *   &lt;ToUserName>&lt;![CDATA[toUser]]>&lt;/ToUserName>
 *   &lt;FromUserName>&lt;![CDATA[fromUser]]>&lt;/FromUserName>
 *   &lt;CreateTime>12345678&lt;/CreateTime>
 *   &lt;MsgType>&lt;![CDATA[news]]>&lt;/MsgType>
 *   &lt;ArticleCount>2&lt;/ArticleCount>
 *   &lt;Articles>
 *     &lt;item>
 *       &lt;Title>&lt;![CDATA[title1]]>&lt;/Title>
 *       &lt;Description>&lt;![CDATA[description1]]>&lt;/Description>
 *       &lt;PicUrl>&lt;![CDATA[picurl]]>&lt;/PicUrl>
 *       &lt;Url>&lt;![CDATA[url]]>&lt;/Url>
 *     &lt;/item>
 *     &lt;item>
 *       &lt;Title>&lt;![CDATA[title]]>&lt;/Title>
 *       &lt;Description>&lt;![CDATA[description]]>&lt;/Description>
 *       &lt;PicUrl>&lt;![CDATA[picurl]]>&lt;/PicUrl>
 *       &lt;Url>&lt;![CDATA[url]]>&lt;/Url>
 *     &lt;/item>
 *   &lt;/Articles>
 * &lt;/xml>
 * </pre>
 *
 * <pre>
 * 参数            是否必须    描述
 * ToUserName      是        接收方帐号（收到的OpenID）
 * FromUserName    是        开发者微信号
 * CreateTime      是        消息创建时间 （整型）
 * MsgType         是        news
 * ArticleCount    是        图文消息个数，限制为10条以内
 * Articles        是        多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应
 * Title           否        图文消息标题
 * Description     否        图文消息描述
 * PicUrl          否        图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
 * Url             否        点击图文消息跳转链接
 * </pre>
 *
 * @author xgx
 *
 */
@XmlRootElement(name = "xml")
public class OutReplyNewsMessage extends BaseOutMessage {

    @XmlAccessorType(XmlAccessType.NONE)
    @XmlType(name = "article")
    public static class Article implements XmlSerializable {

        @XmlElement(name = "PicUrl")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String picUrl;

        @XmlElement(name = "Url")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String url;

        @XmlElement(name = "Title")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String title;

        @XmlElement(name = "Description")
        @XmlJavaTypeAdapter(AdapterCDATA.class)
        protected String description;

        public String getDescription() {
            return description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        public void setDescription(final String description) {
            this.description = description;
        }

        public void setPicUrl(final String picUrl) {
            this.picUrl = picUrl;
        }

        public void setTitle(final String title) {
            this.title = title;
        }

        public void setUrl(final String url) {
            this.url = url;
        }

    }

    @XmlElement(name = "ArticleCount", nillable = false, required = true)
    protected int articleCount;

    @XmlElementWrapper(name = "Articles")
    @XmlElements(value = { @XmlElement(name = "item", type = Article.class) })
    protected List<Article> articles;

    public int getArticleCount() {
        return articleCount;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticleCount(final int articleCount) {
        this.articleCount = articleCount;
    }

    public void setArticles(final List<Article> articles) {
        this.articles = articles;
    }
}
