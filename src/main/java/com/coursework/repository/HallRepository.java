package com.coursework.repository;

import com.coursework.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Integer> {

    List<Hall> findByCinemaId(Integer cinemaId);

    Hall findByHallId(Integer id);

    void deleteByHallId(Integer integer);
}
