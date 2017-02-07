package com.coursework.services.impl;

import com.coursework.model.Hall;
import com.coursework.repository.HallRepository;
import com.coursework.services.HallService;
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

    public Hall getHallByID(Integer hallId) {
        return hallRepository.findOne(hallId);
    }

    public List<Hall> getHallByCinemaId(Integer cinemaId) {
        return hallRepository.findByCinemaId(cinemaId);
    }

    public void deleteHallByID(Integer id) {
        if (getHallByID(id) != null) {
            hallRepository.delete(id);
        }
    }

    public Hall addHall(Hall hall) {
        return hallRepository.saveAndFlush(hall);
    }

}
