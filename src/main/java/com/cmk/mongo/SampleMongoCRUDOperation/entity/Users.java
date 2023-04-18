package com.cmk.mongo.SampleMongoCRUDOperation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(collection = "users-with-address")
public class Users {
    @Id
    private String id;

    private Long userId;

    private String firstName;
    private String lastName;

    private String email;

    private Address address;

}
