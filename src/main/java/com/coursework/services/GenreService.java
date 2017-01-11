package com.coursework.services;

import com.coursework.model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getAllGenre();

    Genre getGenreByID(Integer id);

    void deleteGenreById(Integer id);

    void addGenre(Genre genre);
}

