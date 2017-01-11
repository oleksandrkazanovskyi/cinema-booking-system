package com.coursework.services;

import com.coursework.model.Ticket;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TicketService {

    public Page<Ticket> getAllTicketsPage(Integer pageNumber);

    public List<Ticket> getAllTicket();

    public List<Ticket> getTicketBySessionNotSold(Integer filmSessionId);

    public Ticket getTicketByID(Integer id);

    public void updateTicket(Ticket ticket);

    public void setPrice(Integer sessionId, Integer price);
}
