package org.wxapi.common.model.msg.in;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.wxapi.common.model.msg.MessageTestResource;
import org.wxapi.common.model.msg.MessageType;
import org.wxapi.common.util.JaxbHelper;

public class GenericXmlInMessageTest extends MessageTestResource {

    private final JaxbHelper<GenericXmlInMessage> jaxbHelper = new JaxbHelper<>(GenericXmlInMessage.class);

    @Test
    public void testUnmarshalEventClick() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(eventClick);
        assertEquals(msg.getMsgType(), MessageType.EVENT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.EVENT);
    }

    @Test
    public void testUnmarshalEventLocation() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(eventLocation);
        assertEquals(msg.getMsgType(), MessageType.EVENT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.EVENT);
    }

    @Test
    public void testUnmarshalEventScan() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(eventScan);
        assertEquals(msg.getMsgType(), MessageType.EVENT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.EVENT);
    }

    @Test
    public void testUnmarshalEventSubscribe() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(eventSubscribe);
        assertEquals(msg.getMsgType(), MessageType.EVENT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.EVENT);
    }

    @Test
    public void testUnmarshalEventView() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(eventView);
        assertEquals(msg.getMsgType(), MessageType.EVENT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.EVENT);
    }

    @Test
    public void testUnmarshalImage() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalImage);
        assertEquals(msg.getMsgType(), MessageType.IMAGE);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.IMAGE);
    }

    @Test
    public void testUnmarshalLink() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalLink);
        assertEquals(msg.getMsgType(), MessageType.LINK);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.LINK);
    }

    @Test
    public void testUnmarshalLocation() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalLocation);
        assertEquals(msg.getMsgType(), MessageType.LOCATION);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.LOCATION);
    }

    @Test
    public void testUnmarshalReplyImage() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(replyImage);
        assertEquals(msg.getMsgType(), MessageType.IMAGE);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.IMAGE);
    }

    @Test
    public void testUnmarshalReplyMusic() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(replyMusic);
        assertEquals(msg.getMsgType(), MessageType.MUSIC);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.MUSIC);
    }

    @Test
    public void testUnmarshalReplyNews() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(replyNews);
        assertEquals(msg.getMsgType(), MessageType.NEWS);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.NEWS);
    }

    @Test
    public void testUnmarshalReplyText() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(replyText);
        assertEquals(msg.getMsgType(), MessageType.TEXT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.TEXT);
    }

    @Test
    public void testUnmarshalReplyVideo() throws JAXBException {

        GenericXmlInMessage msg = jaxbHelper.unmarshal(replyVideo);
        assertEquals(msg.getMsgType(), MessageType.VIDEO);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.VIDEO);
    }

    @Test
    public void testUnmarshalReplyVoice() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(replyVoice);
        assertEquals(msg.getMsgType(), MessageType.VOICE);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.VOICE);
    }

    @Test
    public void testUnmarshalShortvideo() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalShortvideo);
        assertEquals(msg.getMsgType(), MessageType.SHORTVIDEO);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.SHORTVIDEO);
    }

    @Test
    public void testUnmarshalText() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalText);
        assertEquals(msg.getMsgType(), MessageType.TEXT);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.TEXT);
    }

    @Test
    public void testUnmarshalVideo() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalVideo);
        assertEquals(msg.getMsgType(), MessageType.VIDEO);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.VIDEO);
    }

    @Test
    public void testUnmarshalVoice() throws JAXBException {
        GenericXmlInMessage msg = jaxbHelper.unmarshal(normalVoice);
        assertEquals(msg.getMsgType(), MessageType.VOICE);

        String str = jaxbHelper.marshal(msg);
        msg = jaxbHelper.unmarshal(str);
        assertEquals(msg.getMsgType(), MessageType.VOICE);
    }

}
