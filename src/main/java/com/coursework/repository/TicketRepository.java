package com.coursework.repository;

import com.coursework.model.Actor;
import com.coursework.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByFilmSessionIdOrderByRowNumberAscSeatAsc(int sessionID);

    void deleteTicketByFilmSessionId(int sessionID);

    List<Ticket> findByUserId(int userId);

    @Modifying
    @Query("update Ticket t set t.price = ?2 where t.filmSessionId= ?1 ")
    @Transactional
    void setPrice(int sessionId, int price);
}
