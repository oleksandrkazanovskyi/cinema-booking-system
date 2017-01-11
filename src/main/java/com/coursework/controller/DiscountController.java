package com.coursework.controller;

import com.coursework.model.Discount;
import com.coursework.services.impl.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class DiscountController {

    @Autowired
    private DiscountServiceImpl discountService;

    @RequestMapping(value = "/admin/discount", method = RequestMethod.GET)
    public String allDiscount(Model model) {
        model.addAttribute("discounts", discountService.getAllDiscount());
        return "/admin/discount";
    }

    @RequestMapping(value = "/discount", method = RequestMethod.GET)
    public String allDiscountUser(Model model) {
        model.addAttribute("discounts", discountService.getAllDiscount());
        return "/discount";
    }

    @RequestMapping(value = "/admin/add/discount", method = RequestMethod.GET)
    public String getDiscountAdd(Model model) {
        model.addAttribute("discount", new Discount());
        return "/admin/add/discount";
    }

    @RequestMapping(value = "/admin/add/discount", method = RequestMethod.POST)
    public String newCinema(@Valid Discount discount, BindingResult bindingResult, Model model) {
        discountService.addDiscount(discount);
        return "redirect:/admin/discount";
    }

    @RequestMapping(value = "/admin/delete/discount", method = RequestMethod.GET, params = {"discountId"})
    public String deleteDiscount(@RequestParam int discountId, Model model) {
        discountService.deleteDiscountByID(discountId);
        return "redirect:/admin/discount";
    }

    @RequestMapping(value = "/admin/edit/discount", method = RequestMethod.GET, params = {"discountId"})
    public String getDiscountEdit(@RequestParam int discountId, Model model) {
        model.addAttribute("discount", discountService.getDiscountByID(discountId));
        return "/admin/edit/discount";
    }
}
