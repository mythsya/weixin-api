package org.wxapi.common.model.menu;

import org.wxapi.common.codetable.Language;
import org.wxapi.common.codetable.PlatformType;
import org.wxapi.common.codetable.Sex;
import org.wxapi.common.model.JsonSerializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 菜单匹配规则
 *
 * <pre>
 * 开发者可以通过以下条件来设置用户看到的菜单：
 *
 *1、用户分组（开发者的业务需求可以借助用户分组来完成）
 *2、性别
 *3、手机操作系统
 *4、地区（用户在微信客户端设置的地区）
 *5、语言（用户在微信客户端设置的语言）
 *
 *示例
 *
 *"matchrule":{
 *    "group_id":"2",
 *    "sex":"1",
 *    "country":"中国",
 *    "province":"广东",
 *    "city":"广州",
 *    "client_platform_type":"2"
 *    "language":"zh_CN"
 *}
 * </pre>
 *
 * @author xgx
 *
 */
public class MatchRule implements JsonSerializable {
    private String groupId;
    private Sex sex;
    private String country;
    private String province;
    private String city;
    private PlatformType clientPlatformType;
    private Language language;

    public MatchRule() {
    }

    public MatchRule(final String groupId, final Sex sex, final String country, final String province, final String city, final PlatformType clientPlatformType, final Language language) {
        this.groupId = groupId;
        this.sex = sex;
        this.country = country;
        this.province = province;
        this.city = city;
        this.clientPlatformType = clientPlatformType;
        this.language = language;
    }

    /**
     * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     *
     * @return
     */
    @JsonProperty("city")
    @JsonInclude(Include.NON_EMPTY)
    public String getCity() {
        return city;
    }

    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     *
     * @return
     */
    @JsonProperty("client_platform_type")
    @JsonInclude(Include.NON_EMPTY)
    public PlatformType getClientPlatformType() {
        return clientPlatformType;
    }

    /**
     * 国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     *
     * @return
     */
    @JsonProperty("country")
    @JsonInclude(Include.NON_EMPTY)
    public String getCountry() {
        return country;
    }

    /**
     * 用户分组id，可通过用户分组管理接口获取
     *
     * @return
     */
    @JsonProperty("group_id")
    @JsonInclude(Include.NON_EMPTY)
    public String getGroupId() {
        return groupId;
    }

    /**
     * 语言信息，是用户在微信中设置的语言，具体请参考语言表： 1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK
     * "zh_HK" 4、英文 "en" 5、印尼 "id" 6、马来 "ms" 7、西班牙 "es" 8、韩国 "ko" 9、意大利 "it"
     * 10、日本 "ja" 11、波兰 "pl" 12、葡萄牙 "pt" 13、俄国 "ru" 14、泰文 "th" 15、越南 "vi"
     * 16、阿拉伯语 "ar" 17、北印度 "hi" 18、希伯来 "he" 19、土耳其 "tr" 20、德语 "de" 21、法语 "fr"
     *
     * @return
     */
    @JsonProperty("language")
    @JsonInclude(Include.NON_EMPTY)
    public Language getLanguage() {
        return language;
    }

    /**
     * 省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     *
     * @return
     */
    @JsonProperty("province")
    @JsonInclude(Include.NON_EMPTY)
    public String getProvince() {
        return province;
    }

    /**
     * 性别：男（1）女（2），不填则不做匹配
     *
     * @return
     */
    @JsonProperty("sex")
    @JsonInclude(Include.NON_EMPTY)
    public Sex getSex() {
        return sex;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setClientPlatformType(final PlatformType clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public void setProvince(final String province) {
        this.province = province;
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
    }

}
