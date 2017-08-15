package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
