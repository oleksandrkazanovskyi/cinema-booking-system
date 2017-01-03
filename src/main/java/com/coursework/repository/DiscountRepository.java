package com.coursework.repository;

import com.coursework.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    Discount findByTittle(String tittle);

    void deleteByTittle(String tittle);
}
