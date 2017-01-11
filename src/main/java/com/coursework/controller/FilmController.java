package com.coursework.controller;

import com.coursework.model.Film;
import com.coursework.services.impl.ActorServiceImpl;
import com.coursework.services.impl.FilmServiceImpl;
import com.coursework.services.GenreService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class FilmController {


    @Autowired
    private FilmServiceImpl filmService;

    @Autowired
    private ActorServiceImpl actorService;

    @Autowired
    private GenreService genreService;

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
    public String getFilmAdd(Model model) {
        model.addAttribute("film", new Film());
        return "/admin/add/film";
    }

    @RequestMapping(value = "/admin/add/film", method = RequestMethod.POST)
    public String newFilm(@Valid Film film, @RequestParam(value = "image") MultipartFile image, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.addFilm(film);
        if (!image.isEmpty()) {
            try {
                validateImage(image);
            } catch (RuntimeException re) {
                bindingResult.addError(new ObjectError("image", "Only jpg images"));
                return "error";
            }
            try {
                saveImage(film.getFilmId() + "", image);
            } catch (IOException e) {
                bindingResult.reject(e.getMessage());
                return "error";
            }
        }
        return "redirect:/admin/film";
    }

    @RequestMapping(value = "/admin/delete/film", method = RequestMethod.GET, params = {"filmId"})
    public String deleteFilm(@RequestParam int filmId, Model model) {
        filmService.deleteFilmByID(filmId);
        return "redirect:/admin/film";
    }

    @RequestMapping(value = "/admin/edit/film", method = RequestMethod.GET, params = {"filmId"})
    public String getFilmEdit(@RequestParam int filmId, Model model) {
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/edit/film";
    }

    @RequestMapping(value = "/admin/add/genre_to_film", method = RequestMethod.GET, params = {"filmId"})
    public String getGenresToAdd(@RequestParam int filmId, Model model) {
        model.addAttribute("allGenres", genreService.getAllGenre());
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/add/genre_to_film";
    }

    @RequestMapping(value = "/admin/add/genre_to_film", method = RequestMethod.POST)
    public String addGenresToFilm(@Valid Film film, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.updateFilm(film);
        return "redirect:/admin/film";
    }

    @RequestMapping(value = "/details/film", method = RequestMethod.GET)
    public String getFilmDetails(@RequestParam int filmId, Model model) {
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/details/film";
    }

    @RequestMapping(value = "/admin/add/actor_to_film", method = RequestMethod.GET, params = {"filmId"})
    public String getActorsToAdd(@RequestParam int filmId, Model model) {
        model.addAttribute("allActors", actorService.getAllActors());
        model.addAttribute("film", filmService.getFilmByID(filmId));
        return "/admin/add/actor_to_film";
    }

    @RequestMapping(value = "/admin/add/actor_to_film", method = RequestMethod.POST)
    public String addActorsToFilm(@Valid Film film, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        filmService.updateFilm(film);
        return "redirect:/admin/film";
    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    private void saveImage(String filename, MultipartFile image)
            throws RuntimeException, IOException {
        try {
            File file = new File("src/main/resources/public/img/"
                    + filename + ".jpg");

            FileUtils.writeByteArrayToFile(file, image.getBytes());
        } catch (IOException e) {
            throw e;
        }
    }
}
