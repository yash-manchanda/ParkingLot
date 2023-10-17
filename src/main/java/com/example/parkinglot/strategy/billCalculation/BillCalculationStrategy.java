package com.example.parkinglot.strategy.billCalculation;

import com.example.parkinglot.models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    double calculateBillAmount(Ticket ticket, LocalDateTime exitTime);
}
