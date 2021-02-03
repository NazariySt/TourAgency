package com.softserve.academy.services;

import com.softserve.academy.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> getRoomsForConcreteDatesByHotelID(Integer hotelId, String start, String end);

    void save(Integer hotelId, Integer roomClassId);

    void bookingRoom(Integer roomId, String bookingDate, String userName);

    void delete(int id);

    Room getOne(int id);

    void update(int id, int hotelId, int roomNumber);

    List<Room> getAllRoomsInHotel(int id);
}
