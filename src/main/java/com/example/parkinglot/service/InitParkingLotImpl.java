package com.example.parkinglot.service;

import com.example.parkinglot.models.*;
import com.example.parkinglot.models.constants.*;
import com.example.parkinglot.repository.GateRepository;
import com.example.parkinglot.repository.ParkingFloorRepository;
import com.example.parkinglot.repository.ParkingLotRepository;
import com.example.parkinglot.repository.ParkingSlotRepository;
import com.example.parkinglot.strategy.billCalculation.BillCalculationStrategyFactory;
import com.example.parkinglot.strategy.slotAllocation.SlotAllocationStrategyFactory;
import com.example.parkinglot.strategy.slotAllocation.SlotStrategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitParkingLotImpl implements InitParkingLot{


    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingFloorRepository parkingFloorRepository;
    private final ParkingLotRepository parkingLotRepository;
    private final GateRepository gateRepository;

    public InitParkingLotImpl(ParkingSlotRepository parkingSlotRepository, ParkingFloorRepository parkingFloorRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }

    @Override
    public void initParkingLot() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("Street A, City B, State C");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setSupportedVehicleTypes(new ArrayList<>(Arrays.asList(VehicleType.BIKE, VehicleType.CAR)));
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.giveSlotAllocationStrategy(SlotStrategies.NEAREST));
        parkingLot.setBillCalculationStrategy(BillCalculationStrategyFactory.getStrategy(com.example.parkinglot.strategy.billCalculation.BillStrategies.HIGH));

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);
            parkingFloor.setId(i);
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                VehicleType supportedVehicleType = j % 2 != 0 ? VehicleType.BIKE : VehicleType.CAR;
                ParkingSlot parkingSlot = new ParkingSlot(i * 100 + j, i * 100 + j, supportedVehicleType);
                parkingSlots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }
            parkingFloor.setParkingSlots(parkingSlots);

            Gate entryGate = new Gate();
            entryGate.setId(i * 10 + 1);
            entryGate.setGateNumber(i * 10 + 1);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Rahul");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);
            gateRepository.put(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId(i * 10 + 2);
            exitGate.setGateNumber(i * 10 + 2);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("Ram");
            exitGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);
            gateRepository.put(exitGate);

            List<Gate> gates = List.of(entryGate, exitGate);
            parkingFloor.setGates(gates);

            parkingFloorRepository.put(parkingFloor);

            parkingFloors.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
    }
}
