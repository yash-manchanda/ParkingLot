package com.example.parkinglot.exception;

public class ParkingLotNotFoundException extends Exception{
    public ParkingLotNotFoundException() {
    }

    public ParkingLotNotFoundException(String message) {
        super(message);
    }
}
