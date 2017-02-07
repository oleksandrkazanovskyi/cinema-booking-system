package com.coursework.repository;

import com.coursework.model.FilmSession;
import com.coursework.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RowRepository extends JpaRepository<Row, Integer> {

    List<Row> findByHallId(int hallId);

    void deleteByRowIndexAndHallId(int rowIndex, int hallId);

    Row findByRowIndexAndHallId(int rowIndex, int hallId);

    List<Row> findByHallFilmSessions(FilmSession filmSession);
}
