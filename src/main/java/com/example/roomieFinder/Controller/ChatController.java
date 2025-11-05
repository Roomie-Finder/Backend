//package com.example.roomieFinder.Controller;
//
//import com.example.roomieFinder.Entities.ChatMessage;
//import com.example.roomieFinder.Repository.ChatMessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import java.util.Date;
//
//@Controller
//public class ChatController {
//
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    private ChatMessageRepository chatMessageRepository;
//
//    @MessageMapping("/chat.send")
//    public void handleChatMessage(@Payload ChatMessage chatMessage) {
//
//        chatMessage.setTimestamp(new Date());
//
//        chatMessageRepository.save(chatMessage);
//
//        messagingTemplate.convertAndSendToUser(
//                String.valueOf(chatMessage.getRecipientId()),
//                "/queue/messages",
//                chatMessage
//        );
//    }
//}
