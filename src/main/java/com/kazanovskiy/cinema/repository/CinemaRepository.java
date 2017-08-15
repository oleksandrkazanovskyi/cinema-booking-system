package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
