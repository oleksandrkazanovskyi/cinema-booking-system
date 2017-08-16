package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
}
