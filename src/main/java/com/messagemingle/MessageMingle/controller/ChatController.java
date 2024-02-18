package com.messagemingle.MessageMingle.controller;

import com.messagemingle.MessageMingle.entity.ChatMessageEntity;
import com.messagemingle.MessageMingle.service.ChatMessageService;
import com.messagemingle.MessageMingle.utility.ChatNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    public ChatController(SimpMessagingTemplate messagingTemplate,
                          ChatMessageService chatMessageService) {
        this.messagingTemplate = messagingTemplate;
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageEntity chatMessage) {
        ChatMessageEntity savedMsg = chatMessageService.save(chatMessage);

        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                new ChatNotification(
                        savedMsg.getId(),
                        savedMsg.getSenderId(),
                        savedMsg.getRecipientId(),
                        savedMsg.getContent()
                )
        );

    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessageEntity>> findChatMessages(@PathVariable String senderId,
                                                                    @PathVariable String recipientId) {

        List<ChatMessageEntity> response = chatMessageService.findChatMessages(senderId, recipientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
