package org.wxapi.common.model.menu;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MenuButtonTypeTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void whenDeserializingUsingJsonValue_thenCorrect() throws JsonParseException, IOException {
        String enumString = "\"scancode_waitmsg\"";
        MenuButtonType mbType = objectMapper.readValue(enumString, MenuButtonType.class);
        assertThat(mbType, is(MenuButtonType.SCANCODE_WAITMSG));
    }

    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws JsonParseException, IOException {
        String enumAsString = objectMapper.writeValueAsString(MenuButtonType.SCANCODE_WAITMSG);
        assertThat(enumAsString, is("\"scancode_waitmsg\""));
    }

}
