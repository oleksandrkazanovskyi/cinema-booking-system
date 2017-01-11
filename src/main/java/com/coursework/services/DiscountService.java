package com.coursework.services;

import com.coursework.model.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> getAllDiscount();

    Discount getDiscountByID(Integer id);

    void deleteDiscountByID(Integer id);

    Discount addDiscount(Discount discount);
}
