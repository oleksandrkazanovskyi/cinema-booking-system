package com.coursework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(RowPK.class)
public class Row implements Serializable {
    private int rowIndex;
    private int hallId;
    private int cinemaId;
    private int seats;
    private Hall hall;

    public Row() {
    }

    public Row(int rowIndex, int hallId, int cinemaId, int seats) {
        this.rowIndex = rowIndex;
        this.hallId = hallId;
        this.cinemaId = cinemaId;
        this.seats = seats;
    }

    @Id
    @Column(name = "Row_index")
    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Id
    @Column(name = "Hall_ID")
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    @Id
    @Column(name = "Cinema_ID")
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Column(name = "Seats")
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Row row = (Row) o;

        if (rowIndex != row.rowIndex) return false;
        if (hallId != row.hallId) return false;
        if (cinemaId != row.cinemaId) return false;
        if (seats != row.seats) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowIndex;
        result = 31 * result + hallId;
        result = 31 * result + cinemaId;
        result = 31 * result + seats;
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "Hall_ID", referencedColumnName = "Hall_ID", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "Cinema_ID", referencedColumnName = "Cinema_ID", nullable = false, insertable = false, updatable = false)})
    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Row{" +
                "Row Index=" + rowIndex +
                ", HallControllerUser Id=" + hallId +
                ", Cinema Id=" + cinemaId +
                ", Seats=" + seats +
                ", HallControllerUser=" + hall +
                '}';
    }
}
