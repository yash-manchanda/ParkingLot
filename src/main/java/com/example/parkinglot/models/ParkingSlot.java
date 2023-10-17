package com.example.parkinglot.models;

import com.example.parkinglot.models.constants.ParkingSlotStatus;
import com.example.parkinglot.models.constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private int number;
    private VehicleType supportedVehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private Vehicle vehicle;

    public ParkingSlot(int id, int number, VehicleType supportedVehicleType) {
        super(id);
        this.number = number;
        this.supportedVehicleType = supportedVehicleType;
        this.parkingSlotStatus = ParkingSlotStatus.AVAILABLE;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(VehicleType supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}