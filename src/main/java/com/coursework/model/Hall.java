package com.coursework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@IdClass(HallPK.class)
public class Hall implements Serializable {
    private Integer hallId;
    private Integer cinemaId;
    private String hallTittle;
    private String desctiption;
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

    @Id
    @Column(name = "Cinema_ID")
    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Column(name = "Hall_Tittle")
    public String getHallTittle() {
        return hallTittle;
    }

    public void setHallTittle(String hallTittle) {
        this.hallTittle = hallTittle;
    }

    @Column(name = "Desctiption")
    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
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
        return hallTittle;
    }
}
