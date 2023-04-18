package com.cmk.mongo.SampleMongoCRUDOperation.mapper;

import com.cmk.mongo.SampleMongoCRUDOperation.dto.UserDto;
import com.cmk.mongo.SampleMongoCRUDOperation.entity.Users;
import com.cmk.mongo.SampleMongoCRUDOperation.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.xml.transform.Source;

@Mapper(componentModel="spring", uses = UserService.class)
public interface UserMapper {

    Users userDtoToEntity(UserDto userDto);
    UserDto userEntityToDto(Users user);
}
