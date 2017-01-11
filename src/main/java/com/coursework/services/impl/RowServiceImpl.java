package com.coursework.services.impl;

import com.coursework.model.Row;
import com.coursework.repository.RowRepository;
import com.coursework.services.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowServiceImpl implements RowService {

    @Autowired
    private RowRepository rowRepository;

    public Row addRow(Row row) {
        return rowRepository.saveAndFlush(row);
    }

    public void deleteRowByRowIndexAndHallId(int rowIndex, int hallId) {
        if (rowRepository.findByRowIndexAndHallId(rowIndex, hallId) != null) {
            rowRepository.deleteByRowIndexAndHallId(rowIndex, hallId);
        }
    }

    public Row getRowByHallIdAndRowIndex(int hallId, int rowIndex) {
        return rowRepository.findByRowIndexAndHallId(rowIndex, hallId);
    }

    public List<Row> getRowByHall(Integer hallId) {
        return rowRepository.findByHallId(hallId);
    }

    public List<Row> getAllRow() {
        return rowRepository.findAll();
    }

    @Override
    public List<Row> getRowBySession(Integer filmSessionId) {
        return rowRepository.getRowBySession(filmSessionId);
    }
}
