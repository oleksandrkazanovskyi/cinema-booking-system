package com.coursework.repository;

import com.coursework.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("select a from Actor a")
    Page<Actor> findAllActors(Pageable pageable);

    Actor getByFirstNameAndLastName(String firstName, String lastName);

    List<Actor> getByLastName(String lastName);
}
