package org.wxapi.common.model.msg.out.reply;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.wxapi.common.model.msg.MessageTestResource;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.JaxbHelper;

public class OutReplyVoiceMessageTest extends MessageTestResource {

    private final JaxbHelper<OutReplyVoiceMessage> jaxbHelper = new JaxbHelper<>(BaseOutMessage.class, OutReplyVoiceMessage.class);

    @Test
    public void testUnmarshal() throws JAXBException {
        OutReplyVoiceMessage msg = jaxbHelper.unmarshal(replyVoice);
        assertEquals(msg.getMsgType(), MessageType.VOICE);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.VOICE);
    }

}
