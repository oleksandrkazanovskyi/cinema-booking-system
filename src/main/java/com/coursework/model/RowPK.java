package com.coursework.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RowPK implements Serializable {
    private int rowIndex;
    private int hallId;
    private int cinemaId;

    public RowPK() {
    }

    @Column(name = "Row_index")
    @Id
    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Column(name = "Hall_ID")
    @Id
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    @Column(name = "Cinema_ID")
    @Id
    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RowPK rowPK = (RowPK) o;

        if (rowIndex != rowPK.rowIndex) return false;
        if (hallId != rowPK.hallId) return false;
        if (cinemaId != rowPK.cinemaId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowIndex;
        result = 31 * result + hallId;
        result = 31 * result + cinemaId;
        return result;
    }
}
