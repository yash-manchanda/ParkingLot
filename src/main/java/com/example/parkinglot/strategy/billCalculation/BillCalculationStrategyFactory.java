package com.example.parkinglot.strategy.billCalculation;

public class BillCalculationStrategyFactory {

    public static BillCalculationStrategy getStrategy(BillStrategies strategy){
        return strategy.equals(BillStrategies.LOW) ? new LowBillCalculationStrategy() : new HighBillCalculationStrategy();
    }
}
