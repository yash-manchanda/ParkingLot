package com.example.parkinglot.repository;

import com.example.parkinglot.exception.GateNotFoundException;
import com.example.parkinglot.models.Gate;

import java.util.HashMap;

public class GateRepository {
    private HashMap<Integer, Gate> gateMap;

    public GateRepository(){
        gateMap = new HashMap<>();
    }

    public Gate get(int id){
        Gate gate = gateMap.get(id);
        if(gate == null){
            throw new GateNotFoundException("Gate not found with ID : "+id);
        }
        return gate;
    }

    public Gate put(Gate gate){
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}
