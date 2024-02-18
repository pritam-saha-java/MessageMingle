package com.messagemingle.MessageMingle.service;

import com.messagemingle.MessageMingle.entity.ChatMessageEntity;

import java.util.List;

public interface ChatMessageService {

    ChatMessageEntity save(ChatMessageEntity chatMessage);

    List<ChatMessageEntity> findChatMessages(String senderId, String recipientId);
}
