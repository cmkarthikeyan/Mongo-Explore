package com.cmk.mongo.SampleMongoCRUDOperation.util;

import com.cmk.mongo.SampleMongoCRUDOperation.dto.UserDto;
import com.cmk.mongo.SampleMongoCRUDOperation.entity.Address;
import com.cmk.mongo.SampleMongoCRUDOperation.entity.Users;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserServiceUtil {
    public List<UserDto> filteredList(int start, int limit, List<UserDto> users) {
        int total = users.size();
        int end = start + limit < total ? start + limit : start + total - start;
        return users.subList(start,end);
    }

    public Users mapDtoToEntity(UserDto userDto) {
        final var address = Address.builder()
                .pinCode(Objects.nonNull(userDto.getAddress()) ? userDto.getAddress().getPinCode() : null)
                .city(Objects.nonNull(userDto.getAddress()) ? userDto.getAddress().getCity() : null)
                .state(Objects.nonNull(userDto.getAddress()) ? userDto.getAddress().getState() : null)
                .build();

        return Users.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .address(address)
                .build();
    }
    public ExampleMatcher getUsersFilter() {
        return ExampleMatcher
                .matchingAll()
                .withMatcher(AppConstant.EMAIL,ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher(AppConstant.FIRST_NAME,ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher(AppConstant.ADDRESS_PINCODE, ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher(AppConstant.ADDRESS_CITY, ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher(AppConstant.ADDRESS_STATE, ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher(AppConstant.LAST_NAME,ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
    }
}
