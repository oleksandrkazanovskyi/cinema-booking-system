package com.coursework.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class HallPK implements Serializable {

    private Integer hallId;
    private Integer cinemaId;

    public HallPK() {
    }

    @Column(name = "Hall_ID")
    @Id
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    @Column(name = "Cinema_ID")
    @Id
    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HallPK hallPK = (HallPK) o;

        if (hallId != hallPK.hallId) return false;
        return cinemaId == hallPK.cinemaId;

    }

    @Override
    public int hashCode() {
        int result = hallId;
        result = 31 * result + cinemaId;
        return result;
    }
}
