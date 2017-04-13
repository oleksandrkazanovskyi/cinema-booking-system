package com.coursework.repository;

import com.coursework.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    Page<Film> findByTitleContaining(String title, Pageable pageable);
    
    List<Film> findByFilmSessionDateGreaterThan(Timestamp date);
}
