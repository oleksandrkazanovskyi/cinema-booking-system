package com.coursework.services;

import com.coursework.model.FilmSession;

import java.sql.Timestamp;
import java.util.List;

public interface FilmSessionService {

    FilmSession addSession(FilmSession filmSession);

    void deleteSessionById(Integer id);

    List<FilmSession> getAllSession();

    List<FilmSession> getSessionByFilmId(Integer filmId);

    List<FilmSession> getSessionByHallId(Integer hallId);

    List<FilmSession> getSessionByCinemaId(Integer id);

    FilmSession getSessionById(Integer id);

    FilmSession getSessionByHallDate(Integer hallId, Timestamp date);
}
