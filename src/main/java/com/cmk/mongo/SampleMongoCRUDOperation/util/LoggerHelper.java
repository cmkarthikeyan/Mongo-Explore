package com.cmk.mongo.SampleMongoCRUDOperation.util;

import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class LoggerHelper {
    public String messageFormatter(String message, Object ... args) {
        return format(message, args);
    }
}
