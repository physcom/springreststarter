package io.qtechdigital.onlineTutoring.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @MessageMapping("/public.message")
    @SendTo("/topic/public")
    public String sendMessage(String message) {
        logger.info("New message : " + message);
        return message;
    }
}
