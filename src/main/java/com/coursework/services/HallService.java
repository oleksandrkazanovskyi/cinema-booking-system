package com.coursework.services;

import com.coursework.model.Cinema;
import com.coursework.model.Hall;
import com.coursework.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {


    private HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    private boolean existHall(Hall hall) {
        return hallRepository.exists(hall.getHallId());
    }

    public List<Hall> getAllHall() {
        return hallRepository.findAll();
    }

    public Hall getHallByTittleAndCinema(String hallHittle, Cinema cinema) {
        return hallRepository.findByHallTittleAndCinemaId(hallHittle, cinema.getCinemaId());
    }

    public Hall getHallByID(int id) {
        return hallRepository.findByHallId(id);
    }

    public List<Hall> getHallByCinemaId(int id) {
        return hallRepository.findByCinemaId(id);
    }

    public Hall getHallByTittle(String tittle) {
        return hallRepository.findByHallTittle(tittle);
    }

    public void deleteHall(Hall hall) {
        if (existHall(hall)) {
            hallRepository.delete(hall);
        }
    }

    public void deleteHallByID(int id) {
        if (existHall(getHallByID(id))) {
            hallRepository.deleteByHallId(id);
        }
    }

    public void updateHall(Hall hall) {
        hallRepository.save(hall);
    }

    public void addHall(Hall hall) {
        hallRepository.saveAndFlush(hall);
    }


}
