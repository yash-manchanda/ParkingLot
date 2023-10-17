package com.example.parkinglot.exception;

public class ParkingSlotNotFoundException extends Exception{
    public ParkingSlotNotFoundException() {
    }

    public ParkingSlotNotFoundException(String message) {
        super(message);
    }
}
