package com.softserve.academy.controllers;

import com.softserve.academy.services.BookService;
import com.softserve.academy.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class BookingController {
    private final RoomService roomService;
    private final BookService bookingService;

    @Autowired
    public BookingController(RoomService roomService, BookService bookingService) {
        this.roomService = roomService;
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public String booking(@RequestParam int hotelId,
                          @RequestParam String dateFrom,
                          @RequestParam String dateTo,
                          Model model) {
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateTo", dateTo);
        model.addAttribute("rooms", roomService.findAvailableRooms(hotelId, dateFrom, dateTo));
        return "booking";
    }

    @GetMapping("/bookRoom/{idRoom}/{dateFrom}/{dateTo}")
    public String bookRoom(@PathVariable int idRoom,
                           @PathVariable String dateFrom,
                           @PathVariable String dateTo,
                           Principal principal) {
        bookingService.bookRoom(Integer.parseInt(principal.getName()), idRoom, dateFrom, dateTo);
        return "redirect:/profile";
    }
}
