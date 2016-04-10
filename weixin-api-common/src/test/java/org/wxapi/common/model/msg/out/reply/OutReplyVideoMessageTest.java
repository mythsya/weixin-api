package org.wxapi.common.model.msg.out.reply;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.wxapi.common.model.msg.MessageTestResource;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.JaxbHelper;

public class OutReplyVideoMessageTest extends MessageTestResource {

    private final JaxbHelper<OutReplyVideoMessage> jaxbHelper = new JaxbHelper<>(BaseOutMessage.class, OutReplyVideoMessage.class);

    @Test
    public void testUnmarshal() throws JAXBException {
        OutReplyVideoMessage msg = jaxbHelper.unmarshal(replyVideo);
        assertEquals(msg.getMsgType(), MessageType.VIDEO);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.VIDEO);
    }

}
