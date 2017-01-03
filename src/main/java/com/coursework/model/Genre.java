package com.coursework.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Genre {
    private int genreId;
    private String genreTittle;
    private String description;
    private Set<Film> genreFilms;

    public Genre() {
    }

    public Genre(String genreTittle, String description) {
        this.genreTittle = genreTittle;
        this.description = description;
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

    @Column(name = "Genre_Tittle")
    public String getGenreTittle() {
        return genreTittle;
    }

    public void setGenreTittle(String genreTittle) {
        this.genreTittle = genreTittle;
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
    public Set<Film> getGenreFilms() {
        return genreFilms;
    }

    public void setGenreFilms(Set<Film> genreFilms) {
        this.genreFilms = genreFilms;
    }

    @Override
    public String toString() {
        return Integer.toString(genreId);
    }
}
