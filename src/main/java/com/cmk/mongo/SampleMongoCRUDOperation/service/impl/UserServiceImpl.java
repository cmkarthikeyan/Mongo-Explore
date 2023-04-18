package com.cmk.mongo.SampleMongoCRUDOperation.service.impl;

import com.cmk.mongo.SampleMongoCRUDOperation.repository.UserRepository;
import com.cmk.mongo.SampleMongoCRUDOperation.dto.UserDto;
import com.cmk.mongo.SampleMongoCRUDOperation.exception.RecordNotFoundException;
import com.cmk.mongo.SampleMongoCRUDOperation.mapper.UserMapper;
import com.cmk.mongo.SampleMongoCRUDOperation.service.UserService;
import com.cmk.mongo.SampleMongoCRUDOperation.util.LoggerHelper;
import com.cmk.mongo.SampleMongoCRUDOperation.util.UserServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserServiceUtil userServiceUtil;
    private final LoggerHelper loggerHelper;
    @Override
    public void addUser(UserDto userDto) {
        log.info("addUser payload in service {} ", userDto);
        final var users = userMapper.userDtoToEntity(userDto);
        userRepository.save(users);
        log.info("User saved successfully and id is {}",users.getId());
    }

    @Override
    public List<UserDto> getUsersWithFilters(UserDto userDto) {
        log.info("User Search payload in service {} ", userDto);
        final var users = userServiceUtil.mapDtoToEntity(userDto);
        final var usersList = userRepository.findAll(Example.of(users, userServiceUtil.getUsersFilter()));
        if(usersList.size() == 0) {
            throw new RecordNotFoundException(loggerHelper.messageFormatter("No Record found for the search filters firstName: %s lastName: %s email: %s address.pinCode: %s", userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getAddress() == null ? " " :userDto.getAddress().getPinCode() ) , userDto.getTransactionId());
        }
        return usersList.stream().map(userMapper::userEntityToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUsersByName(String name, String transactionId) {
        log.info("getUsersByName users search name is {} transactionId {}", name, transactionId);
        final var users = userRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(loggerHelper.messageFormatter("No Record found for the search filter name: %s", name), transactionId));
        return userMapper.userEntityToDto(users);
    }

    @Override
    public List<UserDto> getUsersByState(String state) {
        final var usersList = userRepository.findByAddress_State(state);
        return usersList.flatMap(Collection::stream)
                .map(userMapper::userEntityToDto)
                .peek(System.out::println)
                .collect(Collectors.toUnmodifiableList());
    }
}
