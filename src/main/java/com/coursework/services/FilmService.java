package com.coursework.services;

import com.coursework.model.Film;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FilmService {

    List<Film> getAllFilms();

    Film getFilmByID(Integer id);

    Page<Film> getAllFilmsPage(Integer pageNumber);

    Page<Film> searchByTittle(String filmTittle, Integer pageNumber);

    List<Film> getLast();

    Film addFilm(Film film);

    void deleteFilmByID(Integer id);
}
