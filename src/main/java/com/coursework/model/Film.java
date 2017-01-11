package com.coursework.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Film {
    private Integer filmId;
    private String filmTittle;
    private int filmDuration;
    private double filmRating;
    private String description;
    private String year;
    private String country;
    private int restriction;
    private Date startFrom;
    private Set<Actor> actors;
    private Set<Genre> genreFilms;

    public Film() {
    }

    @Id
    @GeneratedValue
    @Column(name = "Film_ID")
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }


    @Column(name = "Film_Tittle")
    public String getFilmTittle() {
        return filmTittle;
    }

    public void setFilmTittle(String filmTittle) {
        this.filmTittle = filmTittle;
    }


    @Column(name = "Film_Duration")
    public int getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(int filmDuration) {
        this.filmDuration = filmDuration;
    }

    @Column(name = "Film_Rating")
    public double getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(double filmRating) {
        this.filmRating = filmRating;
    }

    @Column(name = "Desctiption")
    public String getDescription() {
        return description;
    }

    public void setDescription(String desctiption) {
        this.description = desctiption;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "Restriction")
    public int getRestriction() {
        return restriction;
    }

    public void setRestriction(int restriction) {
        this.restriction = restriction;
    }

    @Column(name = "Start_from")
    public Date getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(Date startFrom) {
        this.startFrom = startFrom;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> filmActors) {
        this.actors = filmActors;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genre_film", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"), inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id"))
    public Set<Genre> getGenreFilms() {
        return genreFilms;
    }

    public void setGenreFilms(Set<Genre> genreFilms) {
        this.genreFilms = genreFilms;
    }

    @Override
    public String toString() {
        return Integer.toString(filmId);
    }

}
