package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.Actor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {

    void addActor(Actor actor);

    List<Actor> getAllActors();

    Page<Actor> getAllActorsPage(Integer pageNumber);

    Actor getActorByID(Long id);

    void deleteActorByID(Long id);
}
