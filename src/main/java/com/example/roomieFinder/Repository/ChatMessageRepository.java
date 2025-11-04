package com.example.roomieFinder.Repository;

import com.example.roomieFinder.Entities.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    // This will be useful later for fetching chat history
    List<ChatMessage> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
