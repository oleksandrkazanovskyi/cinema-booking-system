package com.coursework.services.impl;

import com.coursework.model.FilmSession;
import com.coursework.repository.FilmSessionRepository;
import com.coursework.services.FilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service

public class FilmSessionServiceImpl implements FilmSessionService {

    @Autowired
    private FilmSessionRepository filmSessionRepository;

    public FilmSession addSession(FilmSession filmSession) {
        return filmSessionRepository.saveAndFlush(filmSession);
    }

    public void deleteSessionById(Integer id) {
        if (getSessionById(id) != null) {
            filmSessionRepository.deleteByFilmSessionId(id);
        }
    }

    public List<FilmSession> getAllSession() {
        return filmSessionRepository.findAll();
    }

    public List<FilmSession> getSessionByFilmId(Integer filmId) {
        return filmSessionRepository.findByFilmId(filmId);
    }

    public List<FilmSession> getSessionByHallId(Integer hallId) {
        return filmSessionRepository.findByHallId(hallId);
    }

    public List<FilmSession> getSessionByCinemaId(Integer id) {
        return null;//filmSessionRepository.findByCinemaId(id);
    }

    public FilmSession getSessionById(Integer id) {
        return filmSessionRepository.findByFilmSessionId(id);
    }

    public FilmSession getSessionByHallDate(Integer hallId, Timestamp date) {
        return filmSessionRepository.findByHallIdAndDate(hallId, date);
    }

}
