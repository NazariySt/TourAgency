package com.softserve.academy.controllers;

import com.softserve.academy.model.Hotel;
import com.softserve.academy.services.CountryService;
import com.softserve.academy.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {

    private final HotelService hotelService;
    private final CountryService countryService;

    @Autowired
    public HotelController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("/createHotel")
    public String save(Model model) {
        model.addAttribute("country", countryService.getAll());
        return "createHotel";
    }


    @PostMapping("/createHotel")
    public String save(@RequestParam String name,
                       @RequestParam String address,
                       @RequestParam int countryId) {
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotelService.saveHotel(hotel, countryId);
        return "redirect:/hotel";
    }

    @GetMapping("/updateHotel/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("oldHotel", hotelService.getOne(id));
        model.addAttribute("country", countryService.getAll());
        return "updateHotel";
    }

    @PostMapping("/updateHotel/{id}")
    public String update(@RequestParam String name,
                         @RequestParam String address,
                         @RequestParam int countryId,
                         @PathVariable int id) {
        hotelService.updateHotel(id, name, address, countryId);
        return "redirect:/hotel";
    }

    @GetMapping("/deleteHotel/{id}")
    public String delete(@PathVariable int id) {
        hotelService.delete(id);
        return "redirect:/hotel";
    }

    @GetMapping("/hotel")
    public String index(Model model) {
        model.addAttribute("hotels", hotelService.getAll());
        return "hotel";
    }

    @GetMapping("/showCountryHotels")
    public String showCountryHotels(@RequestParam int countryId, Model model) {
        model.addAttribute("hotels", hotelService.getAllHotelsInCountry(countryId));
        return "countryHotels";
    }
}
