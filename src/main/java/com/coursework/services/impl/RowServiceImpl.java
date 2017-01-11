package com.coursework.services.impl;

import com.coursework.model.Cinema;
import com.coursework.model.Hall;
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

    public List<Row> getRowByCinemaAndHall(Cinema cinema, Hall hall) {
        return rowRepository.findByCinemaIdAndHallId(cinema.getCinemaId(), hall.getHallId());
    }

    public List<Row> getAllRow() {
        return rowRepository.findAll();
    }
}
