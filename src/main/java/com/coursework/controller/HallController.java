package com.coursework.controller;

import com.coursework.model.Hall;
import com.coursework.services.CinemaService;
import com.coursework.services.HallService;
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

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private HallService hallService;

    @RequestMapping(value = "/admin/add/hall", method = RequestMethod.GET)
    public String getHallAdd(Model model) {
        model.addAttribute("hall", new Hall());
        model.addAttribute("cinemas", cinemaService.getAllCinema());
        return "/admin/add/hall";
    }

    @RequestMapping(value = "/admin/add/hall", method = RequestMethod.POST)
    public String newHall(@Valid Hall hall, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/hall";
        }
        hallService.addHall(hall);
        return "redirect:/admin/hall";
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

    @RequestMapping(value = "/hall", method = RequestMethod.GET, params = {"cinemaId"})
    public String hallByCinemaUser(@RequestParam int cinemaId, Model model) {
        model.addAttribute("halls", hallService.getHallByCinemaId(cinemaId));
        return "/hall";
    }

    @RequestMapping(value = "/admin/hall", method = RequestMethod.GET, params = {"cinemaId"})
    public String hallByCinema(@RequestParam int cinemaId, Model model) {
        model.addAttribute("halls", hallService.getHallByCinemaId(cinemaId));
        return "/admin/hall";
    }

    @RequestMapping(value = "/admin/edit/hall", method = RequestMethod.GET)
    public String getHallEdit(@RequestParam int hallId, Model model) {
        model.addAttribute("hall", hallService.getHallByID(hallId));
        return "/admin/edit/hall";
    }

    @RequestMapping(value = "/admin/delete/hall", method = RequestMethod.GET, params = {"hallId"})
    public String deleteHall(@RequestParam int hallId, Model model) {
        hallService.deleteHallByID(hallId);
        return "redirect:/admin/hall";
    }
}
