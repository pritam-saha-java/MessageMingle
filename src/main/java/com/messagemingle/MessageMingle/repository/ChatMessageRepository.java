package com.messagemingle.MessageMingle.repository;

import com.messagemingle.MessageMingle.entity.ChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, String> {

    List<ChatMessageEntity> findByChatId(String chatId);
}
