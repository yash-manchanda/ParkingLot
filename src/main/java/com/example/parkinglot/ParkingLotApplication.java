package com.example.parkinglot;

import com.example.parkinglot.controller.TicketController;
import com.example.parkinglot.dto.TicketRequestDTO;
import com.example.parkinglot.dto.TicketResponseDTO;
import com.example.parkinglot.exception.ParkingLotNotFoundException;
import com.example.parkinglot.models.constants.VehicleType;
import com.example.parkinglot.repository.*;
import com.example.parkinglot.service.InitParkingLotImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ParkingLotApplication {

    public static void main(String[] args) throws ParkingLotNotFoundException {

        SpringApplication.run(ParkingLotApplication.class, args);

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitParkingLotImpl initService = new InitParkingLotImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.initParkingLot();
        System.out.println(parkingLotRepository);
        System.out.println(parkingFloorRepository);
        System.out.println(parkingFloorRepository);
        System.out.println(gateRepository);
        System.out.println("----------------------");

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(21);
        ticketRequestDTO.setName("Mercedes");
        ticketRequestDTO.setColor("Blue");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("1234");

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);
    }

}
