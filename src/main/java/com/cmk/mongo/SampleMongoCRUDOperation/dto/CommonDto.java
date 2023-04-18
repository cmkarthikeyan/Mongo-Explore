package com.cmk.mongo.SampleMongoCRUDOperation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonDto extends PaginationDto{
    private String transactionId;
}
