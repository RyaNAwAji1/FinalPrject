package com.example.demo.Exception;

public class TroublesNotFoundException extends RuntimeException {
    public TroublesNotFoundException(String message) {
        super(message);
    }
}
