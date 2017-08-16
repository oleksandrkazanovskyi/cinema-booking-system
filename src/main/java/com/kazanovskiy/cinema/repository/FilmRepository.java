package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Page<Film> findByTitleContaining(String title, Pageable pageable);

}
