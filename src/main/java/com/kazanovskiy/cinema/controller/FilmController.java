package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.Film;
import com.kazanovskiy.cinema.services.ActorService;
import com.kazanovskiy.cinema.services.FilmService;
import com.kazanovskiy.cinema.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class FilmController {


    private final FilmService filmService;

    private final ActorService actorService;

    private final GenreService genreService;

    @Autowired
    public FilmController(FilmService filmService, ActorService actorService, GenreService genreService) {
        this.filmService = filmService;
        this.actorService = actorService;
        this.genreService = genreService;
    }

    @RequestMapping(value = "/admin/film", method = RequestMethod.GET)
    public String allFilms(Model model) {
        model.addAttribute("films", filmService.getAllFilms());
        return "/admin/film";
    }

    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public String allFilmUser(@RequestParam(defaultValue = "1", required = false) Integer page, Model model) {
        Page<Film> pages = filmService.getAllFilmsPage(page);
        model.addAttribute("allFilm", pages);
        model.addAttribute("films", filmService.getAllFilms());
        return "/film";
    }

    @RequestMapping(value = "/film", method = RequestMethod.GET, params = {"filmTittle"})
    public String searchFilm(@RequestParam String filmTittle, @RequestParam(defaultValue = "1", required = false) Integer page, Model model) {
        Page<Film> searchResult = filmService.searchByTittle(filmTittle, page);
        model.addAttribute("allFilm", searchResult);
        return "/film";
    }

    @RequestMapping(value = "/admin/add/film", method = RequestMethod.GET)
    public String addFilm(Model model) {
        model.addAttribute("film", new Film());
        return "/admin/add/film";
    }

    @RequestMapping(value = "/admin/add/film", method = RequestMethod.POST)
    public String addFilm(@Valid Film film, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);

        return "redirect:/admin/film";
    }

    @RequestMapping(value = "/admin/delete/film", method = RequestMethod.GET, params = {"filmId"})
    public String deleteFilm(@RequestParam Long filmId, Model model) {
        filmService.deleteFilmByID(filmId);
        return "redirect:/admin/film";
    }

    @RequestMapping(value = "/admin/edit/film", method = RequestMethod.GET, params = {"filmId"})
    public String editFilm(@RequestParam Long filmId, Model model) {
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/edit/film";
    }

    @RequestMapping(value = "/admin/add/genre_to_film", method = RequestMethod.GET, params = {"filmId"})
    public String addGenres(@RequestParam Long filmId, Model model) {
        model.addAttribute("allGenres", genreService.getAllGenre());
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/add/genre_to_film";
    }

    @RequestMapping(value = "/admin/add/genre_to_film", method = RequestMethod.POST)
    public String addGenres(@Valid Film film, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);
        return "redirect:/admin/film";
    }

    @RequestMapping(value = "/details/film", method = RequestMethod.GET)
    public String getFilm(@RequestParam Long filmId, Model model) {
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/details/film";
    }

    @RequestMapping(value = "/admin/add/actor_to_film", method = RequestMethod.GET, params = {"filmId"})
    public String addActors(@RequestParam Long filmId, Model model) {
        model.addAttribute("allActors", actorService.getAllActors());
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/add/actor_to_film";
    }

    @RequestMapping(value = "/admin/add/actor_to_film", method = RequestMethod.POST)
    public String addActors(@Valid Film film, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);
        return "redirect:/admin/film";
    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

}
