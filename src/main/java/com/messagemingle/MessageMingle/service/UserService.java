package com.messagemingle.MessageMingle.service;

import com.messagemingle.MessageMingle.entity.UserEntity;

import java.util.List;

public interface UserService {

    void saveUser(UserEntity user);

    void disconnect(UserEntity user);

    List<UserEntity> findConnectedUsers();
}
