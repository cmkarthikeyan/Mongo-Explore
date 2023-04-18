package com.cmk.mongo.SampleMongoCRUDOperation.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
public class UserApiResponse {
    private ServiceStatus serviceStatus;
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalCount;
}
