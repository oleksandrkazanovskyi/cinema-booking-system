package com.coursework.services;

import com.coursework.model.Cinema;
import com.coursework.model.Hall;
import com.coursework.model.Row;
import com.coursework.repository.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowService {

    @Autowired
    private RowRepository rowRepository;

    public boolean existRow(Row row) {
        return rowRepository.equals(row);
    }

    public void addRow(Row row) {
        rowRepository.saveAndFlush(row);
    }

    public void deleteRow(Row row) {
        if (existRow(row))
            rowRepository.delete(row);
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

    public void updateRow(Row row) {
        rowRepository.save(row);
    }

}
