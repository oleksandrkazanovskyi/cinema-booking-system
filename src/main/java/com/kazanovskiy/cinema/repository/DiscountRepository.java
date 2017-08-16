package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
