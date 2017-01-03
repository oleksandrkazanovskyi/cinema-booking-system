package com.coursework.services;

import com.coursework.model.FilmSession;
import com.coursework.repository.FilmSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service

public class SessionService {

    @Autowired
    private FilmSessionRepository filmSessionRepository;

    public boolean existSession(int filmSessionId) {
        return filmSessionRepository.exists(filmSessionId);
    }


    public FilmSession addSession(FilmSession filmSession) {
        return filmSessionRepository.saveAndFlush(filmSession);
    }

    public void deleteSession(FilmSession filmSession) {
        filmSessionRepository.delete(filmSession);
    }

    public void deleteSessionById(int id) {
        if (getSessionById(id) != null) {
            filmSessionRepository.deleteByFilmSessionId(id);
        }
    }

    public List<FilmSession> getAllSession() {
        return filmSessionRepository.findAll();
    }

    public List<FilmSession> getSessionByDate(Timestamp date) {
        return filmSessionRepository.findByDate(date);
    }

    public List<FilmSession> getSessionByFilmId(int filmId) {
        return filmSessionRepository.findByFilmId(filmId);
    }

    public List<FilmSession> getSessionByHallId(int hallId) {
        return filmSessionRepository.findByHallId(hallId);
    }

    public List<FilmSession> getSessionByCinemaId(int id) {
        return filmSessionRepository.findByCinemaId(id);
    }

    public FilmSession getSessionById(int id) {
        return filmSessionRepository.findByFilmSessionId(id);
    }

    public FilmSession getSessionByHallDate(int hallId, Timestamp date) {
        return filmSessionRepository.findByHallIdAndDate(hallId, date);
    }

    public FilmSession updateSession(FilmSession filmSession) {
        return filmSessionRepository.saveAndFlush(filmSession);
    }
}
