package com.coursework.repository;

import com.coursework.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RowRepository extends JpaRepository<Row, Integer> {

    List<Row> findByHallId(int hallId);

    @Transactional
    void deleteByRowIndexAndHallId(int rowIndex, int hallId);

    Row findByRowIndexAndHallId(int rowIndex, int hallId);

    @Modifying
    @Query("select r from Row r where r in (select t.row from Ticket t where t.filmSessionId = ?1)")
    @Transactional
    List<Row> getRowBySession(int filmSessionId);
}
