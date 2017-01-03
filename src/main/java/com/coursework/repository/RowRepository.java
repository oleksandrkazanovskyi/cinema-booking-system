package com.coursework.repository;

import com.coursework.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RowRepository extends JpaRepository<Row, Integer> {

    List<Row> findByCinemaIdAndHallId(int cinemaId, int hallId);

    @Transactional
    void deleteByRowIndexAndHallId(int rowIndex, int hallId);

    Row findByRowIndexAndHallId(int rowIndex, int hallId);
}
