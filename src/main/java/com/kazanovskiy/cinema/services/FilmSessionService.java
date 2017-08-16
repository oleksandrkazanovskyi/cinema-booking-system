package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.FilmSession;

import java.util.List;

public interface FilmSessionService {

    FilmSession addSession(FilmSession filmSession);

    void deleteSessionById(Long id);

    List<FilmSession> getAllSession();

    FilmSession getSessionById(Long id);


}
