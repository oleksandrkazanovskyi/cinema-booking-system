package com.coursework.repository;

import com.coursework.model.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface FilmSessionRepository extends JpaRepository<FilmSession, Integer> {

    List<FilmSession> findByFilmId(int filmId);

    List<FilmSession> findByHallId(int hallId);

    FilmSession findByHallIdAndDate(int hallId, Timestamp date);

}
