package com.softserve.academy.services;

import com.softserve.academy.model.Order;
import com.softserve.academy.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(int id);

    List<User> getAll();

    User getOne(int id);

    User getUserWithBookings(int id);

    List<User> getAllUsersWithBookings();

    void update(int userId, String firstName, String lastName, String login);


}
