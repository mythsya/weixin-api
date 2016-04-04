package org.wxapi.common.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;

public class AdapterCDATA extends XmlAdapter<String, String> {

    @Override
    public String marshal(final String s) throws Exception {
        return StringUtils.isNotEmpty(s) ? ("<![CDATA[" + s + "]]>") : s;
    }

    @Override
    public String unmarshal(final String s) throws Exception {
        return s;
    }

}
