package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Row;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RowRepository extends JpaRepository<Row, Long> {
}
