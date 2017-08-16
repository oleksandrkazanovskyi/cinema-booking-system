package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Genre;
import com.kazanovskiy.cinema.repository.GenreRepository;
import com.kazanovskiy.cinema.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    public Genre getGenreByID(Long id) {
        return genreRepository.findOne(id);
    }

    public void deleteGenreById(Long id) {
        if (getGenreByID(id) != null)
            genreRepository.delete(id);
    }

    public void addGenre(Genre genre) {
        genreRepository.saveAndFlush(genre);
    }
}
