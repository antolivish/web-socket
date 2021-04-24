package com.razorthink.aios.websocket.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PublishMsg {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * This method will keeps on publish message to the socket channel
     */
    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        simpMessagingTemplate.convertAndSend("/ide/message",
                "Testing - Current date and time : " + new Date());
    }
}
