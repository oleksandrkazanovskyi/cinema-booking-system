package com.coursework.services;

import com.coursework.model.Actor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorService {

    void addActor(Actor actor);

    List<Actor> getAllActors();

    Page<Actor> getAllActorsPage(Integer pageNumber);

    Actor getActorByID(Integer id);

    void deleteActorByID(Integer id);
}
