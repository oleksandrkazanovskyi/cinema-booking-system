package com.coursework.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Ticket> tickets;

    public Order() {
        tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
