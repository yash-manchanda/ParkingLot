package com.example.parkinglot;

import com.example.parkinglot.repository.*;
import com.example.parkinglot.service.InitParkingLotImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {

    public static void main(String[] args) {

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
        System.out.println("");
    }

}
