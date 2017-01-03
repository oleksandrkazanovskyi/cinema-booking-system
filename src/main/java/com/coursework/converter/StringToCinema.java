package com.coursework.converter;

import com.coursework.model.Cinema;
import com.coursework.services.CinemaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCinema implements Converter<String, Cinema> {

    @Autowired
    private CinemaService cinemaService;

    @Override
    public Cinema convert(String arg) {
        return cinemaService.getCinemaByTittle(arg);

    }
}
