package com.cmk.mongo.SampleMongoCRUDOperation.exception;

import com.cmk.mongo.SampleMongoCRUDOperation.response.ServiceStatus;
import com.cmk.mongo.SampleMongoCRUDOperation.response.UserApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

@ControllerAdvice
public class UserServiceException {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserApiResponse handleRecordNotFoundException(RecordNotFoundException recordNotFoundException) {
       return UserApiResponse.builder()
                .serviceStatus(ServiceStatus.builder()
                        .transactionId(recordNotFoundException.getTransactionId())
                        .statusCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                        .statusFlag(Boolean.FALSE)
                        .statusMsg(recordNotFoundException.getMessage())
                        .build())
                .data(Collections.EMPTY_LIST)
                .build();
    }

}
