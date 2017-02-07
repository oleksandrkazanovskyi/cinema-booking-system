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

    @Query("select f from Film f where f.filmId in (select s.filmId from FilmSession s where s.date > ?1)")
    List<Film> filmFromToday(Timestamp date);
}
