package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Actor;
import com.kazanovskiy.cinema.repository.ActorRepository;
import com.kazanovskiy.cinema.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Value("${page.size}")
    private Integer pageSize;

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public void addActor(Actor actor) {
        actorRepository.saveAndFlush(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Page<Actor> getAllActorsPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "lastName");
        return actorRepository.findAll(request);
    }

    public Actor getActorByID(Long id) {
        return actorRepository.findOne(id);
    }

    public void deleteActorByID(Long id) {
        if (existActor(actorRepository.findOne(id))) {
            actorRepository.delete(id);
        }
    }

    private boolean existActor(Actor actor) {
        return actorRepository.exists(actor.getId());
    }

}
