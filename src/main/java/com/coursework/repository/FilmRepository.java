package com.coursework.repository;

import com.coursework.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film findByFilmTittle(String tittle);

    void deleteByFilmTittle(String tittle);

    //List<Film> findByFilmTittleContaining(String filmTittle);


    Page<Film> findByFilmTittleContaining(String tittle, Pageable pageable);

    @Query("select f from Film f where f.filmId in (select s.filmId from FilmSession s where s.date > ?1)")
    List<Film> filmFromToday(@Param("param1") Timestamp date);
}
