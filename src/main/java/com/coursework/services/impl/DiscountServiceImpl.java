package com.coursework.services.impl;

import com.coursework.model.Discount;
import com.coursework.repository.DiscountRepository;
import com.coursework.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }

    public Discount getDiscountByID(Integer id) {
        return discountRepository.findOne(id);
    }

    public void deleteDiscountByID(Integer id) {
        if (getDiscountByID(id) != null) {
            discountRepository.delete(id);
        }
    }

    public Discount addDiscount(Discount discount) {
        return discountRepository.saveAndFlush(discount);
    }
}
