package org.wxapi.common.model.msg.out.reply;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.wxapi.common.model.msg.MessageTestResource;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.model.msg.out.BaseOutMessage;
import org.wxapi.common.util.JaxbHelper;

public class OutReplyMusicMessageTest extends MessageTestResource {
    private final JaxbHelper<OutReplyMusicMessage> jaxbHelper = new JaxbHelper<>(BaseOutMessage.class, OutReplyMusicMessage.class);

    @Test
    public void testUnmarshal() throws JAXBException {
        OutReplyMusicMessage msg = jaxbHelper.unmarshal(replyMusic);
        assertEquals(msg.getMsgType(), MessageType.MUSIC);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.MUSIC);
    }
}
