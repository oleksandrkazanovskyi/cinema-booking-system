package com.coursework.repository;

import com.coursework.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Integer> {
    List<Hall> findByCinemaId(int cinemaId);

    Hall findByHallTittleAndCinemaId(String hallTittle, int cinemaId);

    Hall findByHallTittle(String hallTittle);

    Hall findByHallId(int id);

    void deleteByHallId(Integer integer);
}
