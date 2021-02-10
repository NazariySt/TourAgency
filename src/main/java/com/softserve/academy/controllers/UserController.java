package com.softserve.academy.controllers;

import com.softserve.academy.model.User;
import com.softserve.academy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

import static java.lang.Integer.parseInt;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String login,
                               @RequestParam String password) {
        userService.save(new User(firstName, lastName, login, password));
        return "redirect:/";
    }

    @GetMapping("/user")
    public String room(Model model) {
        model.addAttribute("users", userService.getAllUsersWithBookings());
        return "user";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserWithBookings(parseInt(principal.getName())));
        return "profile";
    }

    @GetMapping("/updateProfile/{userId}")
    public String updateUserProfile(Model model,
                                    @PathVariable int userId) {
        model.addAttribute("user", userService.getOne(userId));
        return "updateProfile";
    }

    @PostMapping("/updateProfile/{userId}")
    public String updateUserProfile(@PathVariable int userId,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName,
                                    @RequestParam String login) {
        userService.update(userId, firstName, lastName, login);
        return "redirect:/profile";
    }
}
