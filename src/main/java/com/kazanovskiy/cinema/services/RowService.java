package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.Row;

import java.util.List;

public interface RowService {

    Row addRow(Row row);

    List<Row> getAllRow();
}
