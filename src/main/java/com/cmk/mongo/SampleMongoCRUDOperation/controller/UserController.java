package com.cmk.mongo.SampleMongoCRUDOperation.controller;

import com.cmk.mongo.SampleMongoCRUDOperation.dto.UserDto;
import com.cmk.mongo.SampleMongoCRUDOperation.response.ServiceStatus;
import com.cmk.mongo.SampleMongoCRUDOperation.response.UserApiResponse;
import com.cmk.mongo.SampleMongoCRUDOperation.service.UserService;
import com.cmk.mongo.SampleMongoCRUDOperation.swagger.UserServiceDocument;
import com.cmk.mongo.SampleMongoCRUDOperation.util.UserServiceUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class UserController implements UserServiceDocument {
    private final UserService userService;
    private final UserServiceUtil userServiceUtil;


    public UserApiResponse addUser(UserDto userDto) {
        userService.addUser(userDto);
       return UserApiResponse.builder()
                .serviceStatus(ServiceStatus.builder()
                        .transactionId(userDto.getTransactionId())
                        .build())
                .build();
    }
    public UserApiResponse getUsersWithFilters(UserDto userDto){
        final List<UserDto> usersWithFilters = userService.getUsersWithFilters(userDto);
        return UserApiResponse.builder()
                .serviceStatus(ServiceStatus.builder().transactionId(userDto.getTransactionId()).build())
                .totalCount(usersWithFilters.size())
                .data(userServiceUtil.filteredList(userDto.getStart(), userDto.getLimit(), usersWithFilters))
                .build();
    }
    public UserApiResponse getUsersByName(String name, String transactionId) {
        return UserApiResponse.builder()
                .serviceStatus(ServiceStatus.builder().transactionId(transactionId).build())
                .data(userService.getUsersByName(name, transactionId))
                .build();
    }

    @Override
    public UserApiResponse getUsersByState(UserDto userDto) throws ExecutionException, InterruptedException {
        return UserApiResponse.builder()
                .serviceStatus(ServiceStatus.builder().transactionId(userDto.getTransactionId()).build())
                .data(userService.getUsersByState(userDto.getAddress().getState()))
                .build();
    }
}