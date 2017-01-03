package com.coursework.converter;

import com.coursework.model.Film;
import com.coursework.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFilm implements Converter<String, Film> {

    @Autowired
    private FilmService filmService;

    @Override
    public Film convert(String s) {
        return filmService.getByTittle(s);
    }
}
