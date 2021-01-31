package services;

import model.Room;
import model.RoomClass;

import java.util.List;

public interface RoomService {

    List<Room> getRoomsforConcreteDatesByHotelID(Integer hotelId, String start, String end);

    void addRoom(Integer hotelId, Integer roomClassId);

    void bookingRoom(Integer roomId, String bookingDate, String userName);

    List<Room> getAllRoomsClasses();

    Room getRoomById(Integer roomId);

    RoomClass getRoomClassById(Integer roomClassId);


}
