package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Hall;
import com.kazanovskiy.cinema.repository.HallRepository;
import com.kazanovskiy.cinema.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    private HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    public Hall getHallByID(Long hallId) {
        return hallRepository.findOne(hallId);
    }


    public void deleteHallByID(Long id) {
        if (getHallByID(id) != null) {
            hallRepository.delete(id);
        }
    }

    public Hall addHall(Hall hall) {
        return hallRepository.saveAndFlush(hall);
    }

}
