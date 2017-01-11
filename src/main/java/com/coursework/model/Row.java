package com.coursework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@IdClass(RowPK.class)
public class Row implements Serializable {
    private int rowIndex;
    private int hallId;
    private int seats;
    private Hall hall;
    private Collection<Ticket> tickets;

    public Row() {
    }

    @Id
    @Column(name = "Row_index")
    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Id
    @Column(name = "Hall_ID")
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    @Column(name = "Seats")
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @OneToMany(mappedBy = "row")
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @ManyToOne
    @JoinColumn(name = "Hall_ID", referencedColumnName = "Hall_ID", nullable = false, insertable = false, updatable = false)
    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Row row = (Row) o;

        if (rowIndex != row.rowIndex) return false;
        if (hallId != row.hallId) return false;
        return seats == row.seats;

    }

    @Override
    public int hashCode() {
        int result = rowIndex;
        result = 31 * result + hallId;
        result = 31 * result + seats;
        return result;
    }

    @Override
    public String toString() {
        return "Row{" +
                "Row Index=" + rowIndex +
                ", Hall Id=" + hallId +
                ", Seats=" + seats +
                '}';
    }
}
