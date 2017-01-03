package com.coursework.converter;

import com.coursework.model.Hall;
import com.coursework.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToHall implements Converter<String, Hall> {

    @Autowired
    private HallService hallService;

    @Override
    public Hall convert(String s) {
        return hallService.getHallByTittle(s);
    }
}
