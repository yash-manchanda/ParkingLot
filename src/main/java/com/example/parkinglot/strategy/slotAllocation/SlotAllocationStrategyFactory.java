package com.example.parkinglot.strategy.slotAllocation;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy giveSlotAllocationStrategy(SlotStrategies strategy){
        return strategy.equals(SlotStrategies.NEAREST) ? new NearestSlotAllocationStrategy() : null;
    }
}
