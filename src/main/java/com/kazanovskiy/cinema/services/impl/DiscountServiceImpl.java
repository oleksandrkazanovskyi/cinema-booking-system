package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Discount;
import com.kazanovskiy.cinema.repository.DiscountRepository;
import com.kazanovskiy.cinema.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }

    public Discount getDiscountByID(Long id) {
        return discountRepository.findOne(id);
    }

    public void deleteDiscountByID(Long id) {
        if(getDiscountByID(id) != null) {
            discountRepository.delete(id);
        }
    }

    public void addDiscount(Discount discount) {
        discountRepository.saveAndFlush(discount);
    }
}
