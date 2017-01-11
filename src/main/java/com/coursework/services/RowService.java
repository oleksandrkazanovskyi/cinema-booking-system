package com.coursework.services;

import com.coursework.model.Row;

import java.util.List;

public interface RowService {

    Row addRow(Row row);

    void deleteRowByRowIndexAndHallId(int rowIndex, int hallId);

    Row getRowByHallIdAndRowIndex(int hallId, int rowIndex);

    List<Row> getRowByHall(Integer hallId);

    List<Row> getAllRow();

    List<Row> getRowBySession(Integer filmSessionId);
}
