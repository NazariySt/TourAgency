package com.softserve.academy.controllers;

import com.softserve.academy.model.Room;
import com.softserve.academy.services.HotelService;
import com.softserve.academy.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {

    private final RoomService roomService;
    private final HotelService hotelService;

    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }
    @GetMapping("/roomInfo/{id}")
    public String room(Model model, @PathVariable int id) {
        model.addAttribute("rooms", roomService.getAllRoomsInHotel(id));
        return "room";
    }

    @GetMapping("/createRoom")
    public String save(Model model) {
        model.addAttribute("hotels", hotelService.getAll());
        return "createRoom";
    }

    @PostMapping("/createRoom")
    public String save(@RequestParam int roomNumber,
                       @RequestParam int hotelId) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        roomService.save(room, hotelId);
        return "redirect:/roomInfo/" + hotelId;
    }

    @GetMapping("/updateRoom/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("oldRoom", roomService.getOne(id));
        model.addAttribute("hotels", hotelService.getAll());
        return "updateRoom";
    }

    @PostMapping("/updateRoom/{id}")
    public String update(@RequestParam int roomNumber,
                         @RequestParam int hotelId,
                         @PathVariable int id) {
        roomService.update(id, hotelId, roomNumber);
        return "redirect:/roomInfo/" + hotelId;
    }

    @GetMapping("/deleteRoom/{hotelId}/{roomId}")
    public String delete(@PathVariable int hotelId,
                         @PathVariable int roomId) {
        roomService.delete(roomId);
        return "redirect:/roomInfo" + hotelId;
    }
}
