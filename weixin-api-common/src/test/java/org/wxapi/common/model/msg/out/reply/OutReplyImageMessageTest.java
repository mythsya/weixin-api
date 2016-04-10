package org.wxapi.common.model.msg.out.reply;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.wxapi.common.model.msg.MessageTestResource;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.JaxbHelper;

public class OutReplyImageMessageTest extends MessageTestResource {

    private final JaxbHelper<OutReplyImageMessage> jaxbHelper = new JaxbHelper<>(BaseOutMessage.class, OutReplyImageMessage.class);

    @Test
    public void testUnmarshal() throws JAXBException {
        OutReplyImageMessage msg = jaxbHelper.unmarshal(replyImage);
        assertEquals(msg.getMsgType(), MessageType.IMAGE);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.IMAGE);
    }

}
