package com.softserve.academy.controllers;

import com.softserve.academy.services.CountryService;
import com.softserve.academy.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IController {

    private final HotelService hotelService;
    private final CountryService countryService;

    @Autowired
    public IController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("hotels", hotelService.getAll());
        return "i";
    }

    @PostMapping("/")
    public String index() {
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "loginprocessing";
    }

}
