package com.messagemingle.MessageMingle.repository;

import com.messagemingle.MessageMingle.entity.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, String> {

    Optional<ChatRoomEntity> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
