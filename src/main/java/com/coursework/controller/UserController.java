package com.coursework.controller;

import com.coursework.model.User;
import com.coursework.services.DiscountService;
import com.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscountService discountService;

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String allUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "/admin/user";
    }

    @RequestMapping(value = "/admin/edit/user", method = RequestMethod.GET, params = {"userId"})
    public String getUserEdit(@RequestParam int userId, Model model) {
        model.addAttribute("user", userService.findUserById(userId));
        return "/admin/edit/user";
    }

    @RequestMapping(value = "/admin/edit/user", method = RequestMethod.POST)
    public String editUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/user";
        }
        userService.updateUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/delete/user", method = RequestMethod.GET)
    public String deleteUser(@RequestParam int userId, Model model) {
        userService.deleteUserById(userId);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/add/user", method = RequestMethod.GET)
    public String getUserAdd(Model model) {
        model.addAttribute("user", new User());
        return "/admin/add/user";
    }

    @RequestMapping(value = "/admin/add/user", method = RequestMethod.POST)
    public String newUser(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "error";
        }
        userService.save(user);
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserDetails(Model model) {
        model.addAttribute("user", userService.findByUsername(getPrincipal()));
        model.addAttribute("allDiscounts", discountService.getAllDiscount());
        model.addAttribute("discountId", null);
        return "/user";
    }

    @RequestMapping(value = "/user/discount", method = RequestMethod.POST)
    public String addUserDiscount(@Valid User user, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/user?error";

        userService.updateUser(user);
        return "redirect:/user";
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
