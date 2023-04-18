package com.cmk.mongo.SampleMongoCRUDOperation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RecordNotFoundException extends RuntimeException{
    private final String message;
    private  String transactionId = "";

}
