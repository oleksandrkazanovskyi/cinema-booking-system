package com.coursework.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Genre {
    private int genreId;
    private String title;
    private String description;
    private Set<Film> films;

    public Genre() {
    }

    @Id
    @GeneratedValue
    @Column(name = "Genre_ID")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String genreTittle) {
        this.title = genreTittle;
    }

    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genre_film", joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "genre_id"), inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> genreFilms) {
        this.films = genreFilms;
    }

    @Override
    public String toString() {
        return Integer.toString(genreId);
    }
}
