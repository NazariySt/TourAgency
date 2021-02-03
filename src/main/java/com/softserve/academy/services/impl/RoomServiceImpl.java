package com.softserve.academy.services.impl;

import com.softserve.academy.model.Hotel;
import com.softserve.academy.model.Order;
import com.softserve.academy.model.Room;
import com.softserve.academy.ourDAO.HotelDao;
import com.softserve.academy.ourDAO.OrderDao;
import com.softserve.academy.ourDAO.RoomDao;
import com.softserve.academy.services.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;
    private final HotelDao hotelDao;
    private final OrderDao bookingDao;

    public RoomServiceImpl(RoomDao roomDao, HotelDao hotelDao, OrderDao bookingDao) {
        this.roomDao = roomDao;
        this.hotelDao = hotelDao;
        this.bookingDao = bookingDao;
    }

    @Override
    public List<Room> getRoomsForConcreteDatesByHotelID(Integer hotelId, String start, String end) {
        return null;
    }

    @Override
    public void save(Room room, Integer hotelID) {
        Hotel hotel = hotelDao.findOne(hotelID);
        room.setHotel(hotel);
        roomDao.save(room);
    }

    @Override
    public List<Room> findAvailableRooms(int hotelId, String startingDate, String endingDate) {
        List<Room> availableRooms = new ArrayList<>();
        LocalDate start = LocalDate.parse(startingDate, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        LocalDate end = LocalDate.parse(endingDate, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        List<Room> rooms = roomDao.getAllHotelRoomsWithBookings(hotelId);

        for (Room room : rooms) {
            boolean isRoomAvailable = true;
            for (Order booking : room.getBookings()) {
                if (!booking.getEndDate().isBefore(start) && !booking.getStarterDate().isAfter(end)) {
                    isRoomAvailable = false;
                }
            }
            if (isRoomAvailable) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }


    @Override
    public void delete(int id) {
        Room room = roomDao.findOne(id);
        for (Order order : room.getBookings())
            bookingDao.delete(order.getId());
        roomDao.delete(id);
    }

    @Override
    public Room getOne(int id) {
        return roomDao.findOne(id);
    }

    @Override
    public void update(int id, int hotelId, int roomNumber) {
        Room room = roomDao.findOne(id);
        Hotel hotel = hotelDao.findOne(hotelId);
        room.setHotel(hotel);
        room.setRoomNumber(roomNumber);
        roomDao.save(room);
    }

    @Override
    public List<Room> getAllRoomsInHotel(int id) {
        return roomDao.getAllHotelRooms(id);
    }
}
