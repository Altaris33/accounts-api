package com.captain.accounts_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, String fieldName, String fieldValue) {
        super(resource + " not found with the given data: [" + fieldName + ", " + fieldValue + "]");
    }
}
