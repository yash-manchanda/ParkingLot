package com.example.parkinglot.strategy.billCalculation;

import com.example.parkinglot.models.Ticket;
import com.example.parkinglot.models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HighBillCalculationStrategy implements BillCalculationStrategy{
    private static final int TWO_WHEELER_COST = 75;
    private static final int FOUR_WHEELER_COST = 150;
    private static final double INCREMENT_FACTOR = 0.2;


    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime) {
        long totalTime = ChronoUnit.HOURS.between(exitTime, ticket.getEntryTime());
        long costPerHour = ticket.getVehicle().getVehicleType() == VehicleType.CAR
                ? FOUR_WHEELER_COST : TWO_WHEELER_COST;
        double baseCost = costPerHour * totalTime;
        return baseCost + (baseCost * (INCREMENT_FACTOR * (totalTime-1)));
    }
}
