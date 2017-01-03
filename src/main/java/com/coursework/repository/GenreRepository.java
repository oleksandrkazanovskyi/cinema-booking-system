package com.coursework.repository;

import com.coursework.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByGenreTittle(String tittle);

    void deleteByGenreTittle(String tittle);
}
