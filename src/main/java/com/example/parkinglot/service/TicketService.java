package com.example.parkinglot.service;

import com.example.parkinglot.exception.ParkingLotNotFoundException;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException;
}
