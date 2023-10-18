package com.example.parkinglot.controller;

import com.example.parkinglot.dto.TicketRequestDTO;
import com.example.parkinglot.dto.TicketResponseDTO;
import com.example.parkinglot.exception.ParkingLotNotFoundException;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.repository.GateRepository;
import com.example.parkinglot.repository.ParkingLotRepository;
import com.example.parkinglot.repository.TicketRepository;
import com.example.parkinglot.service.TicketService;
import com.example.parkinglot.service.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {
    TicketService ticketService;
    public TicketController(ParkingLotRepository parkingLotRepo, GateRepository gateRepo, TicketRepository ticketRepo){
        this.ticketService = new TicketServiceImpl(parkingLotRepo, gateRepo, ticketRepo);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws ParkingLotNotFoundException {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(), ticketRequestDTO.getName(), ticketRequestDTO.getColor(), ticketRequestDTO.getVehicleType());
        Ticket ticket = this.ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(), ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setEntryTime(ticket.getEntryTime());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getNumber());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());

        return ticketResponseDTO;
    }
}
