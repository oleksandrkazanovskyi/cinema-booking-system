package com.coursework.services.impl;

import com.coursework.model.Cinema;
import com.coursework.repository.CinemaRepository;
import com.coursework.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    private static final int PAGE_SIZE = 10;

    public Page<Cinema> getAllCinemaPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "title");
        return cinemaRepository.findAll(request);
    }

    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    private boolean existCinema(Cinema cinema) {
        return cinemaRepository.exists(cinema.getCinemaId());
    }

    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.saveAndFlush(cinema);
    }

    public void deleteCinemaByID(Integer id) {
        if (existCinema(getCinemaByID(id))) {
            cinemaRepository.delete(id);
        }
    }

    public Cinema getCinemaByID(Integer id) {
        return cinemaRepository.findOne(id);
    }
}
