package com.messagemingle.MessageMingle.controller;

import com.messagemingle.MessageMingle.entity.UserEntity;
import com.messagemingle.MessageMingle.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public UserEntity addUser(@Payload UserEntity user) {
        userService.saveUser(user);
        return user;

    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public UserEntity disconnectUser(@Payload UserEntity user) {
        userService.disconnect(user);
        return user;

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> findConnectedUsers() {
        List<UserEntity> response = userService.findConnectedUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
