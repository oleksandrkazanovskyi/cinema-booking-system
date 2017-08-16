package com.kazanovskiy.cinema.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Row extends BaseEntity {
    private int rowIndex;

    private int seats;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
}
