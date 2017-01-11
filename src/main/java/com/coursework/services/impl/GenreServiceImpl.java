package com.coursework.services.impl;

import com.coursework.model.Genre;
import com.coursework.repository.GenreRepository;
import com.coursework.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    public Genre getGenreByID(Integer id) {
        return genreRepository.findOne(id);
    }

    public void deleteGenreById(Integer id) {
        if (getGenreByID(id) != null)
            genreRepository.delete(id);
    }

    public void addGenre(Genre genre) {
        genreRepository.saveAndFlush(genre);
    }
}
