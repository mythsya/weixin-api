package org.wxapi.common.model.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.wxapi.common.model.JsonSerializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义菜单按钮<br>
 * <br>
 * 输出JSON格式如下
 *
 * <pre>
 * {
 *    "name":"菜单",
 *    "sub_button":[
 *        {
 *            "type":"view",
 *            "name":"搜索",
 *            "url":"http://www.soso.com/"
 *        },
 *        {
 *            "type":"view",
 *            "name":"视频",
 *            "url":"http://v.qq.com/"
 *        },
 *        {
 *            "type":"click",
 *            "name":"赞一下我们",
 *            "key":"V1001_GOOD"
 *        }
 *    ]
 *}
 * </pre>
 *
 * @author xgx
 *
 */
public class MenuButton implements JsonSerializable {

    public static void main(final String[] args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        List<MenuButton> sublist = new ArrayList<MenuButton>();
        sublist.add(new MenuButton(MenuButtonType.LOCATION_SELECT, "test11", "key11", "", "M0201", null));
        sublist.add(new MenuButton(MenuButtonType.PIC_WEIXIN, "test12", "", "http://baidu.com/2", "", null));
        MenuButton mb = new MenuButton(MenuButtonType.CLICK, "test1", "key1", "http://baidu.com", "M0101", sublist);
        String enumAsString = om.writeValueAsString(mb);
        System.out.println(enumAsString);

        MenuButton mb2 = om.readValue(enumAsString, MenuButton.class);
        System.out.println(mb2);

        String enumAsString2 = om.writeValueAsString(mb2);
        System.out.println(enumAsString2);
    }

    private String name;
    private MenuButtonType type;
    private String key;
    private String url;
    private String mediaId;

    private List<MenuButton> children = new ArrayList<MenuButton>();

    public MenuButton() {
    }

    public MenuButton(final MenuButtonType type, final String name, final String key, final String url, final String mediaId, final List<MenuButton> children) {
        this.type = type;
        this.name = name;
        this.key = key;
        this.url = url;
        this.mediaId = mediaId;
        this.children = children;
    }

    /**
     * 二级菜单数组，个数应为1~5个
     *
     * @return
     */
    @JsonProperty("sub_button")
    @JsonInclude(Include.NON_EMPTY)
    public List<MenuButton> getChildren() {
        return children;
    }

    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节。click等点击类型必须
     *
     * @return
     */
    @JsonProperty("key")
    @JsonInclude(Include.NON_EMPTY)
    public String getKey() {
        return key;
    }

    /**
     * 调用新增永久素材接口返回的合法media_id。media_id类型和view_limited类型必须
     *
     * @return
     */
    @JsonProperty("media_id")
    @JsonInclude(Include.NON_EMPTY)
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 菜单标题，不超过16个字节，子菜单不超过40个字节
     *
     * @return
     */
    @JsonProperty(value = "name", required = true)
    public String getName() {
        return name;
    }

    /**
     * 菜单的响应动作类型
     *
     * @return
     */
    @JsonProperty(value = "type", required = true)
    public MenuButtonType getType() {
        return type;
    }

    /**
     * 网页链接，用户点击菜单可打开链接，不超过1024字节。view类型必须
     *
     * @return
     */
    @JsonProperty("url")
    @JsonInclude(Include.NON_EMPTY)
    public String getUrl() {
        return url;
    }

    public void setChildren(final List<MenuButton> children) {
        this.children = children;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public void setMediaId(final String mediaId) {
        this.mediaId = mediaId;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setType(final MenuButtonType type) {
        this.type = type;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

}
