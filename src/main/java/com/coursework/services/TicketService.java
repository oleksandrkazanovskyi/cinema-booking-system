package com.coursework.services;

import com.coursework.model.Ticket;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TicketService {

    Page<Ticket> getAllTicketsPage(Integer pageNumber);

    List<Ticket> getTicketBySession(Integer filmSessionId);

    Ticket getTicketByID(Integer id);

    void updateTicket(Ticket ticket);

    void setPrice(Integer sessionId, Integer price);
}
