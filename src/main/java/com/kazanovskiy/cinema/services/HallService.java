package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.Hall;

import java.util.List;

public interface HallService {

    List<Hall> getAllHall();

    Hall getHallByID(Long id);

    void deleteHallByID(Long id);

    Hall addHall(Hall hall);

}
