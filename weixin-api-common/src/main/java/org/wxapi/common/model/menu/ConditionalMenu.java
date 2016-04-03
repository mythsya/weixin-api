package org.wxapi.common.model.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 个性化菜单 <br>
 *
 * 当公众号创建多个个性化菜单时，将按照发布顺序，由新到旧逐一匹配，直到用户信息与matchrule相符合。如果全部个性化菜单都没有匹配成功，则返回默认菜单。
 * 例如公众号先后发布了默认菜单，个性化菜单1，个性化菜单2，个性化菜单3。那么当用户进入公众号页面时，将从个性化菜单3开始匹配，如果个性化菜单3匹配成功，
 * 则直接返回个性化菜单3，否则继续尝试匹配个性化菜单2，直到成功匹配到一个菜单。
 *
 * @author xgx
 *
 */
public class ConditionalMenu extends Menu {
    private MatchRule matchRule;

    /**
     * 菜单匹配规则
     *
     * @return
     */
    @JsonProperty(value = "matchrule", required = true)
    public MatchRule getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(final MatchRule matchRule) {
        this.matchRule = matchRule;
    }

}
