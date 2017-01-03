package com.coursework.controller;

import com.coursework.model.Genre;
import com.coursework.services.FilmService;
import com.coursework.services.GenreService;
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

    @Autowired
    private GenreService genreService;

    @Autowired
    private FilmService filmService;

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
    public String deleteGenre(@RequestParam int genreId, Model model) {
        genreService.deleteGenreById(genreId);
        return "redirect:/admin/genre";
    }

    @RequestMapping(value = "/admin/edit/genre", method = RequestMethod.GET, params = {"genreId"})
    public String getGenreEdit(@RequestParam int genreId, Model model) {
        model.addAttribute("genre", genreService.getGenreByID(genreId));
        return "/admin/edit/genre";
    }

    @RequestMapping(value = "/admin/add/genre", method = RequestMethod.GET)
    public String getGenreAdd(Model model) {
        model.addAttribute("genre", new Genre());
        return "/admin/add/genre";
    }

    @RequestMapping(value = "/admin/add/genre", method = RequestMethod.POST)
    public String addGenre(@Valid Genre genre, BindingResult bindingResult, Model model) {
        genreService.addGenre(genre);
        return "redirect:/admin/genre";
    }

}
