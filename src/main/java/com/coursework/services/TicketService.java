package com.coursework.services;

import com.coursework.model.FilmSession;
import com.coursework.model.Ticket;
import com.coursework.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private TicketRepository ticketRepository;

    public Page<Ticket> getAllTicketsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE);
        return ticketRepository.findAll(request);
    }

    public boolean existTicket(Ticket ticket) {
        return ticketRepository.exists(ticket.getTicketId());
    }

    public List<Ticket> getAllTicket() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketBySessionNotSold(int filmSessionId) {
        return ticketRepository.findByFilmSessionIdOrderByRowNumberAscSeatAsc(filmSessionId);
    }

    public Ticket getTicketByID(int id) {
        return ticketRepository.findOne(id);
    }

    public List<Ticket> getTicketByUser(int userId) {
        return ticketRepository.findByUserId(userId);
    }

    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    public void deleteTicketBySession(FilmSession filmSession) {
        ticketRepository.deleteTicketByFilmSessionId(filmSession.getFilmSessionId());
    }

    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void setPrice(int sessionId, int price) {
        ticketRepository.setPrice(sessionId, price);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.saveAndFlush(ticket);
    }
}
