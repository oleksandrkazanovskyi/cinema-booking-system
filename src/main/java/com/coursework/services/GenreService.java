package com.coursework.services;

import com.coursework.model.Genre;
import com.coursework.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public boolean existGenre(Genre genre) {
        return genreRepository.exists(genre.getGenreId());
    }

    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }

    public Genre getGenreByID(int id) {
        return genreRepository.findOne(id);
    }

    public Genre getGenreByTittle(String tittle) {
        return genreRepository.findByGenreTittle(tittle);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(String tittle) {
        genreRepository.deleteByGenreTittle(tittle);
    }

    public void deleteGenreById(int id) {
        if (existGenre(getGenreByID(id)))
            genreRepository.delete(id);
    }

    public void addGenre(Genre genre) {
        genreRepository.saveAndFlush(genre);
    }
}
