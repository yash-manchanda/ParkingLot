package com.example.parkinglot.strategy.slotAllocation;

import com.example.parkinglot.exception.SlotNotAvailableException;
import com.example.parkinglot.models.Gate;
import com.example.parkinglot.models.ParkingFloor;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.ParkingSlot;
import com.example.parkinglot.models.constants.ParkingSlotStatus;
import com.example.parkinglot.models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSlot findSlot(ParkingLot parkingLot, VehicleType vehicleType, Gate entryGate) {
        int floorNumber = entryGate.getFloorNumber();
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(floorNumber);
        for(ParkingSlot slot : parkingFloor.getParkingSlots()){
            if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
                    && slot.getSupportedVehicleType().equals(vehicleType)){
                return slot;
            }
        }
        int up = floorNumber +1;
        int down = floorNumber -1;
        while(up < parkingLot.getParkingFloors().size() || down >= 0){
            if(down >= 0){
                ParkingFloor downFloor = parkingLot.getParkingFloors().get(down);
                for(ParkingSlot slot : downFloor.getParkingSlots()){
                    if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
                            && slot.getSupportedVehicleType().equals(vehicleType)){
                        return slot;
                    }
                }
            }
            else if(up < parkingLot.getParkingFloors().size()){
                ParkingFloor upFloor = parkingLot.getParkingFloors().get(down);
                for(ParkingSlot slot : upFloor.getParkingSlots()){
                    if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)
                            && slot.getSupportedVehicleType().equals(vehicleType)){
                        return slot;
                    }
                }
            }
            up++;
            down--;
        }
        throw new SlotNotAvailableException("Slot not available in the Parking lot");
    }
}
