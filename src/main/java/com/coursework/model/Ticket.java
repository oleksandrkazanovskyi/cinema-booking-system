package com.coursework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    private Integer ticketId;
    private Integer filmSessionId;
    private Integer rowNumber;
    private Integer seat;
    private Integer userId;
    private Integer price;
    private Integer hallId;
    private FilmSession filmSession;
    private User user;
    private Row row;

    public Ticket() {
    }


    @Id
    @GeneratedValue
    @Column(name = "Ticket_ID")
    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    @Column(name = "film_Session_ID")
    public Integer getFilmSessionId() {
        return filmSessionId;
    }

    public void setFilmSessionId(Integer sessionId) {
        this.filmSessionId = sessionId;
    }

    @Column(name = "hall_id")
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    @Column(name = "Row_index")
    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Column(name = "Seat")
    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    @Column(name = "user_Id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "film_session_id", referencedColumnName = "film_session_id", insertable = false, updatable = false)
    public FilmSession getFilmSession() {
        return filmSession;
    }

    public void setFilmSession(FilmSession session) {
        this.filmSession = session;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User userByUserId) {
        this.user = userByUserId;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "Row_index", referencedColumnName = "Row_index", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "hall_id", referencedColumnName = "Hall_ID", nullable = false, insertable = false, updatable = false)})
    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return ticketId + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (filmSessionId != ticket.filmSessionId) return false;
        if (price != ticket.price) return false;
        if (hallId != ticket.hallId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmSessionId;
        result = 31 * result + price;
        result = 31 * result + hallId;
        return result;
    }
}
