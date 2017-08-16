package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.Genre;
import com.kazanovskiy.cinema.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller

public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(value = "/admin/genre", method = RequestMethod.GET)
    public String allGenre(Model model) {
        model.addAttribute("genres", genreService.getAllGenre());
        return "/admin/genre";
    }

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public String allGenreUser(Model model) {
        model.addAttribute("genres", genreService.getAllGenre());
        return "/genre";
    }

    @RequestMapping(value = "/admin/delete/genre", method = RequestMethod.GET)
    public String deleteGenre(@RequestParam Long genreId, Model model) {
        genreService.deleteGenreById(genreId);
        return "redirect:/admin/genre";
    }

    @RequestMapping(value = "/admin/edit/genre", method = RequestMethod.GET, params = {"genreId"})
    public String editGenre(@RequestParam Long genreId, Model model) {
        model.addAttribute("genre", genreService.getGenreByID(genreId));
        return "/admin/edit/genre";
    }

    @RequestMapping(value = "/admin/add/genre", method = RequestMethod.GET)
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "/admin/add/genre";
    }

    @RequestMapping(value = "/admin/add/genre", method = RequestMethod.POST)
    public String addGenre(@Valid Genre genre, BindingResult bindingResult, Model model) {
        genreService.addGenre(genre);
        return "redirect:/admin/genre";
    }

}
