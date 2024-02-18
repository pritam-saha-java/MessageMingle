package com.messagemingle.MessageMingle.service.implementation;

import com.messagemingle.MessageMingle.entity.UserEntity;
import com.messagemingle.MessageMingle.exception.DataNotFoundException;
import com.messagemingle.MessageMingle.repository.UserRepository;
import com.messagemingle.MessageMingle.service.UserService;
import com.messagemingle.MessageMingle.utility.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveUser(UserEntity user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    @Override
    public void disconnect(UserEntity user) {
        UserEntity storedUser = repository.findById(user.getNickName())
                .orElseThrow(new DataNotFoundException("User Not Found"));

            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
    }

    @Override
    public List<UserEntity> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);

    }
}
