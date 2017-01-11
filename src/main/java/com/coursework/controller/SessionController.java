package com.coursework.controller;

import com.coursework.model.FilmSession;
import com.coursework.services.*;
import com.coursework.services.impl.CinemaServiceImpl;
import com.coursework.services.impl.FilmServiceImpl;
import com.coursework.services.impl.HallServiceImpl;
import com.coursework.validator.SessionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private HallServiceImpl hallService;

    @Autowired
    private FilmServiceImpl filmService;

    @Autowired
    private CinemaServiceImpl cinemaService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SessionValidator sessionValidator;

    @RequestMapping(value = "/admin/add/session", method = RequestMethod.GET, params = {"cinemaId"})
    public String getSessionAdd(@RequestParam Integer cinemaId, Model model) {
        FilmSession filmSession = new FilmSession();
        filmSession.setCinemaId(cinemaId);
        model.addAttribute("filmSessionId", filmSession.getFilmSessionId());
        model.addAttribute("filmSession", filmSession);
        model.addAttribute("cinemaId", cinemaId);
        model.addAttribute("allHalls", cinemaService.getCinemaByID(cinemaId).getHall());
        model.addAttribute("allFilms", filmService.getAllFilms());
        return "/admin/add/session";
    }

    @RequestMapping(value = "/admin/add/session", method = RequestMethod.POST)
    public String newSession(@Valid FilmSession filmSession, @RequestParam("price") int price, BindingResult bindingResult, Model model) {

        sessionValidator.validate(filmSession, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("allHalls", cinemaService.getCinemaByID(filmSession.getCinemaId()).getHall());
            model.addAttribute("allFilms", filmService.getAllFilms());
            model.addAttribute("price", price);
            return "/admin/add/session";
        }
        filmSession = sessionService.addSession(filmSession);
        ticketService.setPrice(filmSession.getFilmSessionId(), price);
        return "redirect:/admin/session?cinemaId=" + filmSession.getCinemaId();
    }


    @RequestMapping(value = "/admin/delete/session", method = RequestMethod.GET)
    public String deleteSession(@RequestParam int filmSessionId, Model model) {
        sessionService.deleteSessionById(filmSessionId);
        return "redirect:/admin/session";
    }


    @RequestMapping(value = "/admin/session", method = RequestMethod.GET, params = {"cinemaId"})
    public String getAllSessionByCinemaID(@RequestParam int cinemaId, Model model) {
        model.addAttribute("sessions", sessionService.getSessionByCinemaId(cinemaId));
        model.addAttribute("cinemaId", cinemaId);
        return "/admin/session";
    }

    @RequestMapping(value = "/admin/session", method = RequestMethod.GET)
    public String getAllSession(Model model) {
        model.addAttribute("sessions", sessionService.getAllSession());
        return "/admin/session";
    }


    @RequestMapping(value = "/admin/edit/session", method = RequestMethod.GET)
    public String getSessionEdit(@RequestParam int sessionId, Model model) {
        FilmSession filmSession = sessionService.getSessionById(sessionId);
        model.addAttribute("myFilmSession", filmSession);
        model.addAttribute("allHalls", filmSession.getHall().getCinema().getHall());
        model.addAttribute("allFilms", filmService.getAllFilms());
        return "/admin/edit/session";
    }

    @RequestMapping(value = "/admin/edit/session", method = RequestMethod.POST)
    public String editSession(@Valid FilmSession myFilmSession, BindingResult bindingResult, Model model) {
        sessionService.addSession(myFilmSession);
        return "redirect:/admin/session";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET, params = {"cinemaId"})
    public String getAllSessionByCinemaIdUser(@RequestParam int cinemaId, Model model) {
        model.addAttribute("sessions", sessionService.getSessionByCinemaId(cinemaId));
        return "/session";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET, params = {"hallId"})
    public String getAllSessionByHallIdUser(@RequestParam int hallId, Model model) {
        model.addAttribute("sessions", sessionService.getSessionByHallId(hallId));
        return "/session";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET, params = {"filmId"})
    public String getAllSessionByFilmIdUser(@RequestParam int filmId, Model model) {
        model.addAttribute("sessions", sessionService.getSessionByFilmId(filmId));
        return "/session";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String getAllSessionUser(Model model) {
        model.addAttribute("sessions", sessionService.getAllSession());
        return "/session";
    }

    @RequestMapping(value = "/details/session", method = RequestMethod.GET)
    public String getSessionDetails(@RequestParam int sessionId, Model model) {
        model.addAttribute("filmSession", sessionService.getSessionById(sessionId));
        // model.addAttribute("price", ticketService.getTicketBySessionNotSold(sessionService.getSessionById(sessionId)).get(0).getPrice());
        return "/details/session";
    }
}
