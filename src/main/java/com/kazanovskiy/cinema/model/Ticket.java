package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Ticket extends BaseEntity {


    @Embedded
    private Seat seat;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "film_session_id")
    private FilmSession filmSession;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
