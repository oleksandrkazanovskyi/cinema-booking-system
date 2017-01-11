package com.coursework.controller;

import com.coursework.model.Row;
import com.coursework.services.CinemaService;
import com.coursework.services.HallService;
import com.coursework.services.RowService;
import com.coursework.validator.RowValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RowController {

    @Autowired
    private RowService rowService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private HallService hallService;

    @Autowired
    private RowValidator rowValidator;

    @RequestMapping(value = "/admin/add/row", method = RequestMethod.GET)
    public String addRow(Model model, @RequestParam int hallId) {
        Row row = new Row();
        row.setHallId(hallId);
        model.addAttribute("row", row);
        return "/admin/add/row";
    }

    @RequestMapping(value = "/admin/add/row", method = RequestMethod.POST)
    public String addRow(@Valid Row row, Model model, BindingResult bindingResult) {
        rowValidator.validate(row, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/admin/add/row";
        }
        rowService.addRow(row);
        return "redirect:/admin/row?hallId=" + row.getHallId();
    }

    @RequestMapping(value = "/admin/delete/row", method = RequestMethod.GET, params = {"rowIndex", "hallId"})
    public String deleteRow(@RequestParam int rowIndex, @RequestParam int hallId, Model model) {
        rowService.deleteRowByRowIndexAndHallId(rowIndex, hallId);
        return "redirect:/admin/row";
    }

    @RequestMapping(value = "/admin/row", method = RequestMethod.GET)
    public String getRowByHall(@RequestParam("hallId") int hallId, Model model) {
        model.addAttribute("rows", rowService.getRowByHall(hallId));
        model.addAttribute("hallId", hallId);
        return "/admin/row";
    }

   /* @RequestMapping(value = "/admin/row", method = RequestMethod.GET)
    public String allRows(Model model) {
        model.addAttribute("rows", rowService.getAllRow());
        return "/admin/row";
    }*/

    @RequestMapping(value = "/admin/edit/row", method = RequestMethod.GET, params = {"hallId", "rowIndex"})
    public String editRow(@RequestParam int hallId, @RequestParam int rowIndex, Model model) {
        model.addAttribute("row", rowService.getRowByHallIdAndRowIndex(hallId, rowIndex));
        return "/admin/edit/row";
    }
}
