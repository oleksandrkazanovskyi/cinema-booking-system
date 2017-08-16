package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.Hall;
import com.kazanovskiy.cinema.model.Row;
import com.kazanovskiy.cinema.services.CinemaService;
import com.kazanovskiy.cinema.services.HallService;
import com.kazanovskiy.cinema.services.RowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static com.kazanovskiy.cinema.infrastructure.EntityUtils.getDummyEntityById;

@Controller
public class RowController {

    private final RowService rowService;
    private final CinemaService cinemaService;
    private final HallService hallService;


    @Autowired
    public RowController(RowService rowService, CinemaService cinemaService, HallService hallService) {
        this.rowService = rowService;
        this.cinemaService = cinemaService;
        this.hallService = hallService;
    }

    @GetMapping("/admin/add/row")
    public String addRow(Model model, @RequestParam Long hallId) {
        Row row = new Row();
        row.setHall(getDummyEntityById(hallId, Hall.class));
        model.addAttribute("row", row);
        return "/admin/add/row";
    }

    @PostMapping("/admin/add/row")
    public String addRow(@Valid Row row, BindingResult bindingResult) {
        rowService.addRow(row);
        return "redirect:/admin/row?hallId=" + row.getHall().getId();
    }


}