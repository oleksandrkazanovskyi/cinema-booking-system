package com.coursework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ticket implements Serializable {
    private int ticketId;
    private int filmSessionId;
    private int rowNumber;
    private int seat;
    private Integer userId;
    private int price;
    private int isSold;
    private FilmSession filmSession;
    private User user;

    public Ticket() {
    }


    @Id
    @GeneratedValue
    @Column(name = "Ticket_ID")
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    @Column(name = "film_session_ID")
    public int getFilmSessionId() {
        return filmSessionId;
    }

    public void setFilmSessionId(int sessionId) {
        this.filmSessionId = sessionId;
    }

  /*  @Column(name = "Hall_ID")
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }*/

    @Column(name = "Row_number")
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @Column(name = "Seat")
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Column(name = "user_Id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

   /* @Column(name = "Film_ID")
    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    @Column(name = "Cinema_ID")
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }*/

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "is_sold")
    public int getIsSold() {
        return isSold;
    }

    public void setIsSold(int sold) {
        isSold = sold;
    }

    @ManyToOne
    @JoinColumn(name = "film_session_id", referencedColumnName = "film_session_id", insertable = false, updatable = false)
    //@JoinColumns({@JoinColumn(name = "film_Session_id", referencedColumnName = "film_Session_ID", insertable = false, updatable = false), @JoinColumn(name = "Hall_ID", referencedColumnName = "Hall_ID", insertable = false, updatable = false), @JoinColumn(name = "Film_ID", referencedColumnName = "Film_ID", insertable = false, updatable = false), @JoinColumn(name = "Cinema_ID", referencedColumnName = "Cinema_ID", insertable = false, updatable = false)})
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

    @Override
    public String toString() {
        return ticketId + "";
    }
}
