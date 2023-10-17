package com.example.parkinglot.strategy.slotAllocation;

import com.example.parkinglot.models.Gate;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.ParkingSlot;
import com.example.parkinglot.models.constants.VehicleType;

public interface SlotAllocationStrategy {

    ParkingSlot findSlot(ParkingLot parkingLot, VehicleType vehicleType, Gate entryGate);
}
