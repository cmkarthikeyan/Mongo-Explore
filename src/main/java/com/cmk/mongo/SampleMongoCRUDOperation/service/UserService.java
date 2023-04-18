package com.cmk.mongo.SampleMongoCRUDOperation.service;

import com.cmk.mongo.SampleMongoCRUDOperation.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface UserService {
    void addUser(UserDto userDto);

    List<UserDto> getUsersWithFilters(UserDto userDto);

    UserDto getUsersByName(String name, String transactionId);

    List<UserDto> getUsersByState(String state);
}
