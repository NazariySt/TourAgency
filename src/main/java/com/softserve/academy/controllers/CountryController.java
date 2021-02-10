package com.softserve.academy.controllers;

import com.softserve.academy.model.Country;
import com.softserve.academy.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/createCountry")
    public String save() {
        return "createCountry";
    }

    @PostMapping("/createCountry")
    public String save(@RequestParam String name) {
        Country country = new Country();
        country.setName(name);
        countryService.save(country);
        return "redirect:/country";
    }

    @GetMapping("/country")
    public String country(Model model) {
        model.addAttribute("country", countryService.getAll());
        return "country";
    }

    @GetMapping("/deleteCountry/{id}")
    public String delete(@PathVariable int id) {
        countryService.delete(id);
        return "redirect:/country";
    }

    @GetMapping("/updateCountry/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("oldCountry", countryService.getOne(id));
        return "updateCountry";
    }

    @PostMapping("/updateCountry/{id}")
    public String update(@RequestParam String name,
                         @PathVariable int id) {
        countryService.update(id, name);
        return "redirect:/country";
    }
}
