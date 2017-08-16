package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.Discount;
import com.kazanovskiy.cinema.services.DiscountService;
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

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

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
    public String addDiscount(Model model) {
        model.addAttribute("discount", new Discount());
        return "/admin/add/discount";
    }

    @RequestMapping(value = "/admin/add/discount", method = RequestMethod.POST)
    public String addDiscount(@Valid Discount discount, BindingResult bindingResult, Model model) {
        discountService.addDiscount(discount);
        return "redirect:/admin/discount";
    }

    @RequestMapping(value = "/admin/delete/discount", method = RequestMethod.GET, params = {"discountId"})
    public String deleteDiscount(@RequestParam Long discountId, Model model) {
        discountService.deleteDiscountByID(discountId);
        return "redirect:/admin/discount";
    }

    @RequestMapping(value = "/admin/edit/discount", method = RequestMethod.GET, params = {"discountId"})
    public String editDiscount(@RequestParam Long discountId, Model model) {
        model.addAttribute("discount", discountService.getDiscountByID(discountId));
        return "/admin/edit/discount";
    }
}
