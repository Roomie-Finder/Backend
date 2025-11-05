//package com.example.roomieFinder.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker // This enables WebSocket messaging
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//
//        registry.enableStompBrokerRelay("/topic", "/queue")
//                .setRelayHost("localhost")
//                .setRelayPort(61613)  // <-- Is this DEFINITELY 61613? (not 61614)
//                .setSystemLogin("guest")
//                .setSystemPasscode("guest");
//
//        registry.setApplicationDestinationPrefixes("/app");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        // This is the HTTP URL that clients use to "handshake"
//        // and upgrade their connection to a WebSocket.
//        // "/ws-chat" is your main WebSocket endpoint.
//        registry.addEndpoint("/ws-chat").withSockJS();
//    }
//}
