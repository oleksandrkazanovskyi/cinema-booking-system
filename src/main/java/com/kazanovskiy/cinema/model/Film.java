package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Film extends BaseEntity {

    private String title;
    private int duration;
    private String description;
    private String year;
    private String country;
    private int restriction;
    private LocalDate startFrom;

    @ManyToMany(mappedBy = "films")
    private Set<Actor> actors;

    @ManyToMany(mappedBy = "films")
    private Set<Genre> genres;

}
