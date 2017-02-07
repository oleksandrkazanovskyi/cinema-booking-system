package com.coursework.services.impl;

import com.coursework.model.Film;
import com.coursework.repository.FilmRepository;
import com.coursework.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Page<Film> getAllFilmsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "title");
        return filmRepository.findAll(request);
    }

    public Film getFilmByID(Integer id) {
        return filmRepository.findOne(id);
    }

    public Page<Film> searchByTittle(String filmTittle, Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "title");
        return filmRepository.findByTitleContaining(filmTittle, request);
    }

    public List<Film> getLast() {
        List<Film> films = new ArrayList<>();
        List<Film> filmsFromToday = filmRepository.filmFromToday(Timestamp.valueOf(LocalDateTime.now()));
        films.addAll(filmsFromToday);
        return films;
    }

    public Film addFilm(Film film) {
        return filmRepository.saveAndFlush(film);
    }

    public void deleteFilmByID(Integer id) {
        if (getFilmByID(id) != null) {
            filmRepository.delete(id);
        }
    }
}
