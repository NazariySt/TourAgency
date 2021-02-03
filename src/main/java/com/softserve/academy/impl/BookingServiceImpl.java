package com.softserve.academy.impl;

import com.softserve.academy.model.Order;
import com.softserve.academy.model.Room;
import com.softserve.academy.model.User;
import com.softserve.academy.ourDAO.OrderDao;
import com.softserve.academy.ourDAO.RoomDao;
import com.softserve.academy.ourDAO.UserDao;
import com.softserve.academy.services.BookService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingServiceImpl implements BookService {

    private final OrderDao bookingDao;
    private final UserDao userDao;
    private final RoomDao roomDao;

    public BookingServiceImpl(OrderDao bookingDao, UserDao userDao, RoomDao roomDao) {
        this.bookingDao = bookingDao;
        this.userDao = userDao;
        this.roomDao = roomDao;
    }

    @Override
    public void bookRoom(int userId, int roomId, String startDate, String endDate) {
        LocalDate startingDate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        LocalDate endingDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        Order order = new Order();
        order.setStarterDate(startingDate);
        order.setEndDate(endingDate);

        User user = userDao.findOne(userId);
        Room room = roomDao.findOne(roomId);
        order.setUser(user);
        order.setRoom(room);
        bookingDao.save(order);
    }
}
