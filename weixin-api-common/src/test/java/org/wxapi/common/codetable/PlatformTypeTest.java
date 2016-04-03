package org.wxapi.common.codetable;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlatformTypeTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void whenDeserializingUsingJsonValue_thenCorrect() throws JsonParseException, IOException {
        String enumString = "\"1\"";
        PlatformType mbType = objectMapper.readValue(enumString, PlatformType.class);
        assertThat(mbType, is(PlatformType.IOS));
    }

    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws JsonParseException, IOException {
        String enumAsString = objectMapper.writeValueAsString(PlatformType.ANDROID);
        assertThat(enumAsString, is("2"));
    }

}
