package com.messagemingle.MessageMingle.repository;

import com.messagemingle.MessageMingle.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long> {

    List<ChatMessageEntity> findByChatId(Long chatId);
}
