package com.softserve.academy.ourDAO;

import com.softserve.academy.model.Room;

import java.util.List;

public interface RoomDao extends DAO<Room , Integer>{

    List<Room> getAllHotelRoomsWithBookings(int id);

    List<Room> getAllHotelRooms(int id);

}
