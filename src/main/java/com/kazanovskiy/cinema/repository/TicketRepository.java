package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Modifying
    @Transactional
    @Query("update Ticket t set t.price = ?2 where t.filmSessionId= ?1 ")
    void setPrice(Long sessionId, int price);
}
