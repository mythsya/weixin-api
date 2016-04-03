package org.wxapi.common.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterCDATA extends XmlAdapter<String, String> {

    @Override
    public String marshal(final String s) throws Exception {
        return "<![CDATA[" + s + "]]>";
    }

    @Override
    public String unmarshal(final String s) throws Exception {
        return s;
    }

}
