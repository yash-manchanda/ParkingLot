package com.example.parkinglot.exception;

public class GateNotFoundException extends RuntimeException{
    public GateNotFoundException(String message) {
        super(message);
    }
}
