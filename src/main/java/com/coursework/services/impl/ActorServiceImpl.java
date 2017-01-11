package com.coursework.services.impl;

import com.coursework.model.Actor;
import com.coursework.repository.ActorRepository;
import com.coursework.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ActorRepository actorRepository;

    public void addActor(Actor actor) {
        actorRepository.saveAndFlush(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Page<Actor> getAllActorsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        return actorRepository.findAll(request);
    }

    public Actor getActorByID(Integer id) {
        return actorRepository.findOne(id);
    }

    public void deleteActorByID(Integer id) {
        if (existActor(actorRepository.findOne(id))) {
            actorRepository.delete(id);
        }
    }

    private boolean existActor(Actor actor) {
        return actorRepository.exists(actor.getActorId());
    }

}
