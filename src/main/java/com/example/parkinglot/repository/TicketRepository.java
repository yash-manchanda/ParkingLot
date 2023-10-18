package com.example.parkinglot.repository;

import com.example.parkinglot.exception.TicketNotFoundException;
import com.example.parkinglot.models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Integer, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketMap.get(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("Ticket not found for Id : " + ticketId);
        }
        return ticket;
    }

    public Ticket put(Ticket ticket){
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }

    @Override
    public String toString() {
        return "TicketRepository{" +
                "ticketMap=" + ticketMap +
                '}';
    }
}
