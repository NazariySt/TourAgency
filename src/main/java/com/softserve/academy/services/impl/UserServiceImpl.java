package com.softserve.academy.services.impl;

import com.softserve.academy.model.Role;
import com.softserve.academy.model.User;
import com.softserve.academy.ourDAO.UserDao;
import com.softserve.academy.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByName(s);
    }

    @Override
    public void save(User user) {
        user.setRole(Role.ROLE_USER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User getOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public User getUserWithBookings(int id) {
        return userDao.getUserWithBookingsByID(id);
    }

    @Override
    public List<User> getAllUsersWithBookings() {
        return userDao.getAllUsersWithBookings();
    }

    @Override
    public void update(int userId, String firstName, String lastName, String login) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        userDao.save(user);
    }

}
