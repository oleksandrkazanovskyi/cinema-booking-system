package com.coursework.controller;

import com.coursework.model.Row;
import com.coursework.services.impl.CinemaServiceImpl;
import com.coursework.services.impl.HallServiceImpl;
import com.coursework.services.impl.RowServiceImpl;
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
    private RowServiceImpl rowService;

    @Autowired
    private CinemaServiceImpl cinemaService;

    @Autowired
    private HallServiceImpl hallService;

    @Autowired
    private RowValidator rowValidator;

    @RequestMapping(value = "/admin/add/row", method = RequestMethod.GET, params = {"cinemaId", "hallId"})
    public String getRowAdd(Model model, @RequestParam int cinemaId, @RequestParam int hallId) {
        Row row = new Row();
        row.setCinemaId(cinemaId);
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
        return "redirect:/admin/row?hallId=" + row.getHallId() + "&cinemaId=" + row.getCinemaId();
    }

    @RequestMapping(value = "/admin/delete/row", method = RequestMethod.GET, params = {"rowIndex", "hallId"})
    public String deleteRow(@RequestParam int rowIndex, @RequestParam int hallId, Model model) {
        rowService.deleteRowByRowIndexAndHallId(rowIndex, hallId);
        return "redirect:/admin/row";
    }

    @RequestMapping(value = "/admin/row", method = RequestMethod.GET, params = {"hallId", "cinemaId"})
    public String viewRowByHall(@RequestParam("hallId") int hallId, @RequestParam("cinemaId") int cinemaId, Model model) {
        model.addAttribute("rows", rowService.getRowByCinemaAndHall(cinemaService.getCinemaByID(cinemaId), hallService.getHallByID(hallId)));
        model.addAttribute("cinemaId", cinemaId);
        model.addAttribute("hallId", hallId);
        return "/admin/row";
    }

    @RequestMapping(value = "/admin/row", method = RequestMethod.GET)
    public String viewRow(Model model) {
        model.addAttribute("rows", rowService.getAllRow());
        return "/admin/row";
    }

    @RequestMapping(value = "/admin/edit/row", method = RequestMethod.GET, params = {"hallId", "rowIndex"})
    public String getRowEdit(@RequestParam int hallId, @RequestParam int rowIndex, Model model) {
        model.addAttribute("row", rowService.getRowByHallIdAndRowIndex(hallId, rowIndex));
        return "/admin/edit/row";
    }
}
