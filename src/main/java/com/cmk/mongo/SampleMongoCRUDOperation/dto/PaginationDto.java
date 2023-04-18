package com.cmk.mongo.SampleMongoCRUDOperation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginationDto {
    private int page;
    private int limit;
    private int start;
}
