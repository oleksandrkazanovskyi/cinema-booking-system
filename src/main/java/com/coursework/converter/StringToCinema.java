package com.coursework.converter;

import com.coursework.model.Cinema;
import com.coursework.services.impl.CinemaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

//@Component
public class StringToCinema implements Converter<String, Cinema> {

    @Autowired
    private CinemaServiceImpl cinemaService;

    @Override
    public Cinema convert(String arg) {
        return cinemaService.getCinemaByTittle(arg);

    }
}
