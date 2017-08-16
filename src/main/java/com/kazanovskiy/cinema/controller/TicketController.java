package com.kazanovskiy.cinema.controller;

import com.kazanovskiy.cinema.model.Ticket;
import com.kazanovskiy.cinema.services.RowService;
import com.kazanovskiy.cinema.services.TicketService;
import com.kazanovskiy.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;
    private final RowService rowService;

    @Autowired
    public TicketController(TicketService ticketService, UserService userService, RowService rowService) {
        this.ticketService = ticketService;
        this.userService = userService;
        this.rowService = rowService;
    }

    @RequestMapping(value = "/admin/edit/ticket", method = RequestMethod.GET, params = {"ticketId"})
    public String editTicket(@RequestParam Long ticketId, Model model) {
        model.addAttribute("ticket", ticketService.findById(ticketId));
        return "/admin/edit/ticket";
    }

    @RequestMapping(value = "/admin/edit/ticket", method = RequestMethod.POST)
    public String editTicket(@Valid Ticket ticket, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/ticket";
        }
        ticketService.update(ticket);
        return "redirect:/admin/ticket";
    }

    @RequestMapping(value = "/admin/ticket", method = RequestMethod.GET)
    public String allTicket(@RequestParam(required = false, defaultValue = "1") Integer page, Model model) {
        Page<Ticket> pages = ticketService.findAll(page);
        model.addAttribute("allTickets", pages);
        return "/admin/ticket";
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public String allTicketBySession(@RequestParam Long filmSessionId, Model model) {
        model.addAttribute("tickets", new ArrayList<Integer>());
        return "/tickets";
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

