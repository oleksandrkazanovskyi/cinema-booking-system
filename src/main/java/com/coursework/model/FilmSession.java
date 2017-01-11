package com.coursework.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "film_session", schema = "courseworkdb", catalog = "")
public class FilmSession {
    private Integer filmSessionId;
    private Integer hallId;
    private Integer filmId;
    private Timestamp date;
    private Film film;
    private Hall hall;
    private Collection<Ticket> tickets;

    @Id
    @GeneratedValue
    @Column(name = "film_Session_ID")
    public Integer getFilmSessionId() {
        return filmSessionId;
    }

    public void setFilmSessionId(Integer filmSessionId) {
        this.filmSessionId = filmSessionId;
    }

    @Basic
    @Column(name = "hall_id")
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    @Basic
    @Column(name = "Film_ID")
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "Date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "Hall_ID", referencedColumnName = "Hall_ID", insertable = false, updatable = false)})
    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @OneToMany(mappedBy = "filmSession")
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmSession that = (FilmSession) o;

        if (filmSessionId != null ? !filmSessionId.equals(that.filmSessionId) : that.filmSessionId != null)
            return false;
        if (hallId != null ? !hallId.equals(that.hallId) : that.hallId != null) return false;
        if (filmId != null ? !filmId.equals(that.filmId) : that.filmId != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = filmSessionId != null ? filmSessionId.hashCode() : 0;
        result = 31 * result + (hallId != null ? hallId.hashCode() : 0);
        result = 31 * result + (filmId != null ? filmId.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
