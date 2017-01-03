package com.coursework.services;

import com.coursework.model.Actor;
import com.coursework.model.Cinema;
import com.coursework.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    private static final int PAGE_SIZE = 10;

    public Page<Cinema> getAllCinemaPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "cinemaTittle");
        return cinemaRepository.findAll(request);
    }


    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }


    public Cinema getCinemaByTittle(String tittle) {
        return cinemaRepository.findByCinemaTittle(tittle);
    }

    private boolean existCinema(Cinema cinema) {
        return cinemaRepository.exists(cinema.getCinemaId());
    }

    public void addCinema(Cinema cinema) {
        cinemaRepository.saveAndFlush(cinema);
    }

    public void updateCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    public void deleteCinemaByTittle(String tittle) {

        if (existCinema(getCinemaByTittle(tittle)))
            cinemaRepository.deleteByCinemaTittle(tittle);
    }

    public void deleteCinemaByID(int id) {
        if (existCinema(getCinemaByID(id))) {
            cinemaRepository.delete(id);
        }
    }

    public Cinema getCinemaByID(int id) {
        return cinemaRepository.findOne(id);
    }
}
