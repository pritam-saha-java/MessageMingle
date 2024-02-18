package com.messagemingle.MessageMingle.repository;

import com.messagemingle.MessageMingle.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, String> {

    Optional<ChatRoomEntity> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
