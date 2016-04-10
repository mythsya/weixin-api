package org.wxapi.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

public final class JaxbHelper<T> {

    private final static Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private JAXBContext context = null;
    private Marshaller marshaller = null;
    private Unmarshaller unmarshaller = null;

    public JaxbHelper(final Class<?>... clazz) {
        this(clazz, true);
    }

    public JaxbHelper(final Class<?>[] clazz, final boolean formattedOutput) {

        try {
            this.context = JAXBContext.newInstance(clazz);
            this.marshaller = context.createMarshaller();
            this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formattedOutput);

            this.marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
                @Override
                public void escape(final char[] ac, final int i, final int j, final boolean flag, final Writer writer) throws IOException {
                    writer.write(ac, i, j);
                }
            });

            this.unmarshaller = context.createUnmarshaller();

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public final String marshal(final T x) throws JAXBException {
        return marshal(x, true);
    }

    public final String marshal(final T x, final boolean withoutXmlHead) throws JAXBException {
        if (marshaller != null) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            marshaller.marshal(x, os);
            String xml = new String(os.toByteArray(), DEFAULT_CHARSET);
            if (withoutXmlHead) {
                return xml.replaceFirst("(?s)<\\?xml.*?\\?>(\r)?(\n)?", "");
            } else {
                return xml;
            }

        } else {
            throw new JAXBException("No JAXBContext exists!");
        }
    }

    @SuppressWarnings("unchecked")
    public final T unmarshal(final String s) throws JAXBException {
        if (unmarshaller != null) {
            T o = (T) unmarshaller.unmarshal(new StringReader(s));
            return o;
        } else {
            throw new JAXBException("No JAXBContext exists!");
        }
    }
}
