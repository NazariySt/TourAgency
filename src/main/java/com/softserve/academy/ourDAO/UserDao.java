package com.softserve.academy.ourDAO;

import com.softserve.academy.model.User;

import java.util.List;

public interface UserDao extends DAO<User , Integer> {

    User findByName(String login);

    User getUserWithBookingsByID(int id);

    List<User> getAllUsersWithBookings();
}
