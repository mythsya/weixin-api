package org.wxapi.common.model.menu;

import java.util.ArrayList;
import java.util.List;

import org.wxapi.common.model.JsonSerializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 自定义菜单的最顶层菜单栏，包含菜单按钮<br>
 *
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。<br>
 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。<br>
 *
 * 输出JSON格式如下
 *
 * <pre>
 * {
 *     "button":[
 *         {
 *             "type":"click",
 *             "name":"今日歌曲",
 *             "key":"V1001_TODAY_MUSIC"
 *         },
 *         {
 *             "name":"菜单",
 *             "sub_button":[
 *                 {
 *                     "type":"view",
 *                     "name":"搜索",
 *                     "url":"http://www.soso.com/"
 *                 },
 *                 {
 *                     "type":"view",
 *                     "name":"视频",
 *                     "url":"http://v.qq.com/"
 *                 }
 *             ]
 *         }
 *     ]
 * }
 * </pre>
 *
 * @author xgx
 *
 */
public class Menu implements JsonSerializable {

    protected List<MenuButton> buttons = new ArrayList<MenuButton>();

    /**
     * 一级菜单数组，个数应为1~3个
     *
     * @return
     */
    @JsonProperty(value = "button", required = true)
    public List<MenuButton> getButtons() {
        return buttons;
    }

    public void setButtons(final List<MenuButton> buttons) {
        this.buttons = buttons;
    }
}
