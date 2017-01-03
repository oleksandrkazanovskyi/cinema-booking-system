package com.coursework.repository;

import com.coursework.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

    Cinema findByCinemaTittle(String tittle);

    void deleteByCinemaTittle(String tittle);
}
