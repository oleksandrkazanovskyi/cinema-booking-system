package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Hall extends BaseEntity {

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "hall")
    private Set<Row> rows;

    @OneToMany(mappedBy = "hall")
    private Set<FilmSession> filmSessions;
}
