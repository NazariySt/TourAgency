package com.softserve.academy.services;

import com.softserve.academy.model.Room;

import java.util.List;

public interface RoomService {


    void save(Room room, Integer hotelID);

    List<Room> findAvailableRooms(int hotelId, String startingDate, String endingDate);

    void delete(int id);

    Room getOne(int id);

    void update(int id, int hotelId, int roomNumber);

    List<Room> getAllRoomsInHotel(int id);
}
