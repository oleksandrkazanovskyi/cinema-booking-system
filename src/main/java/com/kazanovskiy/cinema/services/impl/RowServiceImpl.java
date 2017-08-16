package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Row;
import com.kazanovskiy.cinema.repository.RowRepository;
import com.kazanovskiy.cinema.services.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowServiceImpl implements RowService {

    private final RowRepository rowRepository;


    @Autowired
    public RowServiceImpl(RowRepository rowRepository) {
        this.rowRepository = rowRepository;
    }

    public Row addRow(Row row) {
        return rowRepository.saveAndFlush(row);
    }


    public List<Row> getAllRow() {
        return rowRepository.findAll();
    }
}
