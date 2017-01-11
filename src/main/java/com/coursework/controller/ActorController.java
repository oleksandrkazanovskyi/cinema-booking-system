package com.coursework.controller;

import com.coursework.model.Actor;
import com.coursework.services.ActorService;
import com.coursework.services.impl.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private FilmServiceImpl filmService;

    @RequestMapping(value = "/admin/actor", method = RequestMethod.GET)
    public String allActor(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "/admin/actor";
    }

    @RequestMapping(value = "/actor", method = RequestMethod.GET)
    public String allActorUser(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        // model.addAttribute("actors", actorService.getAllActors());
        Page<Actor> pages = actorService.getAllActorsPage(page);
        model.addAttribute("allActor", pages);
        return "/actor";
    }

    @RequestMapping(value = "/admin/delete/actor", method = RequestMethod.GET)
    public String deleteActor(@RequestParam int actorId) {
        actorService.deleteActorByID(actorId);
        return "redirect:/admin/actor";
    }

    @RequestMapping(value = "/admin/edit/actor", method = RequestMethod.GET, params = {"actorId"})
    public String getActorEdit(@RequestParam int actorId, Model model) {
        model.addAttribute("actor", actorService.getActorByID(actorId));
        return "/admin/edit/actor";
    }


    @RequestMapping(value = "/admin/add/actor", method = RequestMethod.GET)
    public String getActorAdd(Model model) {
        model.addAttribute("actor", new Actor());
        return "/admin/add/actor";
    }

    @RequestMapping(value = "/admin/add/actor", method = RequestMethod.POST)
    public String addActor(@Valid Actor actor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        actorService.addActor(actor);
        return "redirect:/admin/actor";
    }

    @RequestMapping(value = "/details/actor", method = RequestMethod.GET)
    public String getActorDetails(@RequestParam int actorId, Model model) {
        model.addAttribute("actor", actorService.getActorByID(actorId));
        return "/details/actor";
    }

}
