package com.kazanovskiy.cinema.model;

import lombok.Value;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Value
@Embeddable
public class Seat {

    @ManyToOne
    @JoinColumn(name = "row_id")
    private Row row;

    private Integer seat;

}
