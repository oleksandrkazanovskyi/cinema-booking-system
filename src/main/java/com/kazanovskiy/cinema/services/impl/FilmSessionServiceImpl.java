package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.FilmSession;
import com.kazanovskiy.cinema.repository.FilmSessionRepository;
import com.kazanovskiy.cinema.services.FilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FilmSessionServiceImpl implements FilmSessionService {

    private final FilmSessionRepository filmSessionRepository;

    @Autowired
    public FilmSessionServiceImpl(FilmSessionRepository filmSessionRepository) {
        this.filmSessionRepository = filmSessionRepository;
    }

    public FilmSession addSession(FilmSession filmSession) {
        return filmSessionRepository.saveAndFlush(filmSession);
    }

    public void deleteSessionById(Long id) {
        if (getSessionById(id) != null) {
            filmSessionRepository.delete(id);
        }
    }

    public List<FilmSession> getAllSession() {
        return filmSessionRepository.findAll();
    }


    public FilmSession getSessionById(Long id) {
        return filmSessionRepository.findOne(id);
    }


}
