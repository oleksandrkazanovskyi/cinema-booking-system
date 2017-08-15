package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
