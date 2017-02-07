package com.coursework.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Set<Film> films;

    public Actor() {
    }


    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"), inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> filmActors) {
        this.films = filmActors;
    }

    @Override
    public String toString() {
        return Integer.toString(actorId);
    }
}
