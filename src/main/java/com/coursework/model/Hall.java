package com.coursework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Hall implements Serializable {
    private Integer hallId;
    private Integer cinemaId;
    private String title;
    private String description;
    private Cinema cinema;
    private Set<Row> rows;
    private Set<FilmSession> filmSessions;

    @Id
    @GeneratedValue
    @Column(name = "Hall_ID")
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    @Column(name = "Cinema_ID")
    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String hallTittle) {
        this.title = hallTittle;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String desctiption) {
        this.description = desctiption;
    }

    @ManyToOne
    @JoinColumn(name = "Cinema_ID", referencedColumnName = "Cinema_ID", nullable = false, insertable = false, updatable = false)
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @OneToMany(mappedBy = "hall")
    public Set<Row> getRows() {
        return rows;
    }

    public void setRows(Set<Row> rows) {
        this.rows = rows;
    }

    @OneToMany(mappedBy = "hall")
    public Set<FilmSession> getFilmSessions() {
        return filmSessions;
    }

    public void setFilmSessions(Set<FilmSession> filmSessions) {
        this.filmSessions = filmSessions;
    }

    @Override
    public String toString() {
        return title;
    }
}
