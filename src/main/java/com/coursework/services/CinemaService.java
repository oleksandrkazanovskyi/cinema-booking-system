package com.coursework.services;

import com.coursework.model.Cinema;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CinemaService {

    Page<Cinema> getAllCinemaPage(Integer pageNumber);

    List<Cinema> getAllCinema();

    Cinema addCinema(Cinema cinema);

    void deleteCinemaByID(Integer id);

    Cinema getCinemaByID(Integer id);
}
