package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> getAllDiscount();

    Discount getDiscountByID(Long id);

    void deleteDiscountByID(Long id);

    void addDiscount(Discount discount);
}
