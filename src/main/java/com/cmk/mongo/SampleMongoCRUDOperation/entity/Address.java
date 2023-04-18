package com.cmk.mongo.SampleMongoCRUDOperation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private String city;
    private String state;
    private Integer pinCode;
}
