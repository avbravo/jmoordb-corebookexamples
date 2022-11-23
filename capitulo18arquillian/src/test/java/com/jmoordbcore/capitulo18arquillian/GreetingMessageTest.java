package com.jmoordbcore.capitulo18arquillian;

import com.jmoordbcore.capitulo18arquillian.controller.GreetingMessage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GreetingMessageTest {

    @Test
    public void testGreetingMessage() {
        var message = GreetingMessage.of("Say Hello to JatartaEE");
        assertEquals(message.getMessage(), "Say Hello to JatartaEE");
    }
}
