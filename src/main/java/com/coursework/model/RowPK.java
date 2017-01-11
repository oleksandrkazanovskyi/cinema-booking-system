package com.coursework.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RowPK implements Serializable {
    private int rowIndex;
    private int hallId;

    public RowPK() {
    }

    @Column(name = "Row_index")
    @Id
    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Column(name = "Hall_ID")
    @Id
    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RowPK rowPK = (RowPK) o;

        if (rowIndex != rowPK.rowIndex) return false;
        if (hallId != rowPK.hallId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowIndex;
        result = 31 * result + hallId;
        return result;
    }
}
