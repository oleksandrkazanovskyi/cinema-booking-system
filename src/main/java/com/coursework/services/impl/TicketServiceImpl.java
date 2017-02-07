package com.coursework.services.impl;

import com.coursework.model.Ticket;
import com.coursework.repository.TicketRepository;
import com.coursework.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private TicketRepository ticketRepository;

    public Page<Ticket> getAllTicketsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE);
        return ticketRepository.findAll(request);
    }

    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketBySession(Integer filmSessionId) {
        return ticketRepository.findByFilmSessionIdOrderByRowNumberAscSeatAsc(filmSessionId);
    }

    public Ticket getTicketByID(Integer id) {
        return ticketRepository.findOne(id);
    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void setPrice(Integer sessionId, Integer price) {
        ticketRepository.setPrice(sessionId, price);
    }

}
