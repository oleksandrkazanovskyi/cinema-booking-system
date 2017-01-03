package com.coursework.services;

import com.coursework.model.Discount;
import com.coursework.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }

    public Discount getDiscountByTittle(String tittle) {
        return discountRepository.findByTittle(tittle);
    }

    public Discount getDiscountByID(int id) {
        return discountRepository.findOne(id);
    }

    public void deleteDiscount(String tittle) {
        discountRepository.deleteByTittle(tittle);
    }

    public void deleteDiscountByID(int id) {
        if (existDiscount(getDiscountByID(id))) {
            deleteDiscountByID(id);
        }
    }

    public void updateDisctount(Discount discount) {
        discountRepository.save(discount);
    }

    public void addDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public boolean existDiscount(Discount discount) {
        return discountRepository.exists(discount.getDiscountId());
    }
}
