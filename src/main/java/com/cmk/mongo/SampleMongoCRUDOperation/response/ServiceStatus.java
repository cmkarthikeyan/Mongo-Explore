package com.cmk.mongo.SampleMongoCRUDOperation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ServiceStatus {

    @Builder.Default
    private String statusCode = "200";

    @Builder.Default
    private boolean statusFlag = Boolean.TRUE;

    @Builder.Default
    private String statusMsg = "Success";

    private String transactionId;
}
