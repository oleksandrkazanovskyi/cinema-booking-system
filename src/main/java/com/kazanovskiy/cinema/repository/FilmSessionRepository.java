package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.FilmSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmSessionRepository extends JpaRepository<FilmSession, Long> {
}
