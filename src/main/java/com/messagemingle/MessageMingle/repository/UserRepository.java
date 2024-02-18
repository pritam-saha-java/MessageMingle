package com.messagemingle.MessageMingle.repository;

import com.messagemingle.MessageMingle.entity.UserEntity;
import com.messagemingle.MessageMingle.utility.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findAllByStatus(Status status);
}
