package com.messagemingle.MessageMingle.service.implementation;

import com.messagemingle.MessageMingle.entity.ChatMessageEntity;
import com.messagemingle.MessageMingle.exception.BadRequestException;
import com.messagemingle.MessageMingle.repository.ChatMessageRepository;
import com.messagemingle.MessageMingle.service.ChatMessageService;
import com.messagemingle.MessageMingle.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessageServiceImpl(ChatMessageRepository repository,
                                  ChatRoomService chatRoomService) {
        this.repository = repository;
        this.chatRoomService = chatRoomService;
    }

    @Override
    public ChatMessageEntity save(ChatMessageEntity chatMessage) {

        String chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(new BadRequestException("Chat Id Not Found"));

        chatMessage.setChatId(chatId);
        repository.save(chatMessage);

        return chatMessage;
    }

    @Override
    public List<ChatMessageEntity> findChatMessages(String senderId, String recipientId) {
        Optional<String> chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);

        List<ChatMessageEntity> chatMessageEntities= new ArrayList<>();
        if (chatId.isPresent()){
            chatMessageEntities = chatId.map(repository::findByChatId).orElse(new ArrayList<>());
        }

        return chatMessageEntities;
    }

}
