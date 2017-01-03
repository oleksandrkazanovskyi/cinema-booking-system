package com.coursework.repository;

import com.coursework.model.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface FilmSessionRepository extends JpaRepository<FilmSession, Integer> {

    List<FilmSession> findByDate(Timestamp date);

    List<FilmSession> findByFilmId(int filmId);

    List<FilmSession> findByHallId(int hallId);

    List<FilmSession> findByCinemaId(int cinemaId);

    FilmSession findByFilmSessionId(int sessionId);

    FilmSession findByHallIdAndDate(int hallId, Timestamp date);

    void deleteByHallId(int hallId);

    void deleteByFilmId(int filmId);

    @Modifying
    @Query("delete from FilmSession s where s.filmSessionId = ?1")
    @Transactional
    void deleteByFilmSessionId(int filmSessionId);
}
