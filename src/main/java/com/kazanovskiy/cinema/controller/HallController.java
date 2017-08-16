package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.Hall;
import com.kazanovskiy.cinema.services.CinemaService;
import com.kazanovskiy.cinema.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HallController {

    private final CinemaService cinemaService;

    private final HallService hallService;

    @Autowired
    public HallController(CinemaService cinemaService, HallService hallService) {
        this.cinemaService = cinemaService;
        this.hallService = hallService;
    }

    @RequestMapping(value = "/admin/hall", method = RequestMethod.GET)
    public String allHall(Model model) {
        model.addAttribute("halls", hallService.getAllHall());
        return "/admin/hall";
    }

    @RequestMapping(value = "/hall", method = RequestMethod.GET)
    public String allHallUser(Model model) {
        model.addAttribute("halls", hallService.getAllHall());
        return "/hall";
    }

    @RequestMapping(value = "/admin/add/hall", method = RequestMethod.GET)
    public String addHall(Model model) {
        model.addAttribute("hall", new Hall());
        model.addAttribute("cinemas", cinemaService.getAllCinema());
        return "/admin/add/hall";
    }

    @RequestMapping(value = "/admin/add/hall", method = RequestMethod.POST)
    public String addHall(@Valid Hall hall, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/hall";
        }
        hallService.addHall(hall);
        return "redirect:/admin/hall";
    }


    @RequestMapping(value = "/admin/edit/hall", method = RequestMethod.GET)
    public String editHall(@RequestParam Long hallId, Model model) {
        model.addAttribute("hall", hallService.getHallByID(hallId));
        model.addAttribute("cinemas", cinemaService.getAllCinema());
        return "/admin/edit/hall";
    }

    @RequestMapping(value = "/admin/delete/hall", method = RequestMethod.GET, params = {"hallId"})
    public String deleteHall(@RequestParam Long hallId, Model model) {
        hallService.deleteHallByID(hallId);
        return "redirect:/admin/hall";
    }
}
