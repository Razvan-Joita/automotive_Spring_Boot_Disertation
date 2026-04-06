package com.automotive_Spring_Boot_Disertation.automotive_Spring_Boot_Disertation.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
