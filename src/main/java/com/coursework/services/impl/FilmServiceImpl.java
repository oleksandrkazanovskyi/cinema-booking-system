package com.coursework.services.impl;

import com.coursework.model.Actor;
import com.coursework.model.Film;
import com.coursework.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getByTittle(String tittle) {
        return filmRepository.findByFilmTittle(tittle);
    }

    public Film getFilmByID(int id) {
        return filmRepository.findOne(id);
    }

    public Page<Film> getAllFilmsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "filmTittle");
        return filmRepository.findAll(request);
    }

    public Page<Film> searchByTittle(String filmTittle, Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "filmTittle");
        return filmRepository.findByFilmTittleContaining(filmTittle, request);
    }

    public List<Film> getLast() {
        List<Film> films = new ArrayList<>();
        List<Film> filmsFromToday = filmRepository.filmFromToday(Timestamp.valueOf(LocalDateTime.now()));
        films.addAll(filmsFromToday);
        return films;
    }

    public void updateFilm(Film film) {
        filmRepository.save(film);
    }

    public boolean existFilm(Film film) {
        return filmRepository.exists(film.getFilmId());
    }

    public Film addFilm(Film film) {
        return filmRepository.saveAndFlush(film);
    }

    public void deleteFilmByID(int id) {
        if (existFilm(getFilmByID(id))) {
            filmRepository.delete(id);
        }
    }

}
