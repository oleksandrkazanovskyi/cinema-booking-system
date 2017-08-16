package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.User;
import com.kazanovskiy.cinema.services.FilmService;
import com.kazanovskiy.cinema.services.SecurityService;
import com.kazanovskiy.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private final UserService userService;
    private final SecurityService securityService;
    private final FilmService filmService;

    @Autowired
    public LoginController(UserService userService,
                           SecurityService securityService,
                           FilmService filmService) {
        this.userService = userService;
        this.securityService = securityService;
        this.filmService = filmService;
    }


    @RequestMapping(value = "/admin/", method = RequestMethod.GET)
    public String index(Model model) {
        return "/admin/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexUser(Model model) {
        model.addAttribute("films", filmService.getLast());
        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.add(userForm);

        return "redirect:/";
    }


}
