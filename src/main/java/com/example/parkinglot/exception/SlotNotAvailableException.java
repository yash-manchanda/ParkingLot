package com.example.parkinglot.exception;

public class SlotNotAvailableException extends RuntimeException{
    public SlotNotAvailableException(String message) {
        super(message);
    }
}
