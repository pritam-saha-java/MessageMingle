package com.messagemingle.MessageMingle.repository;

import com.messagemingle.MessageMingle.entity.UserEntity;
import com.messagemingle.MessageMingle.utility.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findAllByStatus(Status status);
}
