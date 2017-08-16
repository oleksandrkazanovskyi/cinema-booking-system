package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Cinema;
import com.kazanovskiy.cinema.repository.CinemaRepository;
import com.kazanovskiy.cinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Value("${page.size}")
    private Integer pageSize;

    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Page<Cinema> getAllCinemaPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "title");
        return cinemaRepository.findAll(request);
    }

    public List<Cinema> getAllCinema() {
        return cinemaRepository.findAll();
    }

    private boolean existCinema(Cinema cinema) {
        return cinemaRepository.exists(cinema.getId());
    }

    public void addCinema(Cinema cinema) {
        cinemaRepository.saveAndFlush(cinema);
    }

    public void deleteCinemaByID(Long id) {
        if (existCinema(getCinemaByID(id))) {
            cinemaRepository.delete(id);
        }
    }

    public Cinema getCinemaByID(Long id) {
        return cinemaRepository.findOne(id);
    }
}
