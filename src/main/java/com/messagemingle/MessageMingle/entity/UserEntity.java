package com.messagemingle.MessageMingle.entity;

import com.messagemingle.MessageMingle.utility.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nickName;
    private String fullName;
    private Status status;
}
