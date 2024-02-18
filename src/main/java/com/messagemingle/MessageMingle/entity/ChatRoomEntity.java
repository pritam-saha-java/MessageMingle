package com.messagemingle.MessageMingle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "chat_room")
public class ChatRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
}
