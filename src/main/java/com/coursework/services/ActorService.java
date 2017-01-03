package com.coursework.services;

import com.coursework.model.Actor;
import com.coursework.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private static final int PAGE_SIZE = 10;


    @Autowired
    private ActorRepository actorRepository;

    public void addActor(Actor actor) {
        actorRepository.saveAndFlush(actor);
    }

    public Actor getActorByName(String firstName, String lastName) {
        return actorRepository.getByFirstNameAndLastName(firstName, lastName);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Page<Actor> getAllActorsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        return actorRepository.findAll(request);
    }

    public List<Actor> getActorByLastName(String lastName) {
        return actorRepository.getByLastName(lastName);
    }

    public Actor getActorByID(int id) {
        return actorRepository.findOne(id);
    }

    public void deleteActorByName(String firstName, String lastName) {
        Actor newActor;
        newActor = getActorByName(firstName, lastName);
        if ((newActor != null))
            actorRepository.delete(newActor);
    }

    public void deleteActor(Actor actor) {
        if (existActor(actor)) {
            actorRepository.delete(actor);
        }
    }

    public void deleteActorByID(int id) {
        if (existActor(actorRepository.findOne(id))) {
            actorRepository.delete(id);
        }
    }


    private boolean existActor(Actor actor) {
        return actorRepository.exists(actor.getActorId());
    }

    public void updateActor(Actor newActor) {
        actorRepository.saveAndFlush(newActor);
    }


}
