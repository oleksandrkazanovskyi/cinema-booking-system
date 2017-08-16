package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
