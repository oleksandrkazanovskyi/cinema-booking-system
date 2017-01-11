package com.coursework.converter;

import com.coursework.model.Film;
import com.coursework.services.impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

//@Component
public class StringToFilm implements Converter<String, Film> {

    @Autowired
    private FilmServiceImpl filmService;

    @Override
    public Film convert(String s) {
        return filmService.getByTittle(s);
    }
}
