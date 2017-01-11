package com.coursework.services;

import com.coursework.model.Hall;

import java.util.List;

public interface HallService {

    List<Hall> getAllHall();

    Hall getHallByID(Integer id);

    List<Hall> getHallByCinemaId(Integer id);

    void deleteHallByID(Integer id);

    Hall addHall(Hall hall);

}
