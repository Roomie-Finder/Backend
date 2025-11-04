package com.example.roomieFinder.Controller;

import com.example.roomieFinder.Entities.ChatMessage;
import com.example.roomieFinder.Repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.Date;

@Controller
public class ChatController {

    // This is the Spring class for sending messages to WebSockets
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // This is our MongoDB repository
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    /**
     * This method is called when a client sends a message to "/app/chat.send"
     */
    @MessageMapping("/chat.send")
    public void handleChatMessage(@Payload ChatMessage chatMessage) {

        // 1. Set the timestamp
        chatMessage.setTimestamp(new Date());

        // 2. Save the message to MongoDB
        chatMessageRepository.save(chatMessage);

        // 3. Send the message to the RECIPIENT
        // This is the magic: Spring + RabbitMQ route this message
        // to the specific user's private queue.
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), // The recipient's username or ID
                "/queue/messages",            // The private queue they are subscribed to
                chatMessage                   // The message payload
        );
    }
}
