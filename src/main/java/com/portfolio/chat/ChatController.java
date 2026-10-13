package com.portfolio.chat;
import java.time.Instant;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
@Controller public class ChatController {
 private final SimpMessagingTemplate broker; ChatController(SimpMessagingTemplate broker){this.broker=broker;}
 @MessageMapping("/chat.send") public void send(@Payload ChatMessage message){
   String room = message.room()==null || message.room().isBlank()?"general":message.room();
   String sender = message.sender()==null || message.sender().isBlank()?"Anonymous":message.sender();
   if(message.content()==null || message.content().isBlank() || message.content().length()>1000) return;
   broker.convertAndSend("/topic/rooms/"+room, new ChatMessage(sender,message.content().trim(),room,Instant.now()));
 }
}
