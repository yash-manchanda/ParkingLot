package com.example.parkinglot.service;

import com.example.parkinglot.exception.ParkingLotNotFoundException;
import com.example.parkinglot.models.*;
import com.example.parkinglot.repository.GateRepository;
import com.example.parkinglot.repository.ParkingLotRepository;
import com.example.parkinglot.repository.TicketRepository;
import com.example.parkinglot.strategy.slotAllocation.SlotAllocationStrategyFactory;
import com.example.parkinglot.strategy.slotAllocation.SlotStrategies;

import java.time.LocalDateTime;
import java.util.Objects;

public class TicketServiceImpl implements TicketService{

    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
    }
    @Override
    public Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException {
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        Gate gate = gateRepository.get(gateId);
        ParkingSlot getSlot = Objects.requireNonNull(SlotAllocationStrategyFactory.giveSlotAllocationStrategy(SlotStrategies.NEAREST)).findSlot(parkingLot, vehicle.getVehicleType(), gate);
        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(entryTime);
        ticket.setParkingSlot(getSlot);
        return ticketRepository.put(ticket);
    }
}
