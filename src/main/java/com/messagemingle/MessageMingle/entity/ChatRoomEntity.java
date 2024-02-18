package com.messagemingle.MessageMingle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_room")
public class ChatRoomEntity {

    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
}
