package com.softserve.academy.ourDAO.implementations;

import com.softserve.academy.model.Room;
import com.softserve.academy.ourDAO.RoomDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class RoomDaoImpl extends DAOImpl<Room, Integer> implements RoomDao {
    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setOurClass(Room.class);
    }

    @Transactional
    @Override
    public List<Room> getAllHotelRooms(int id) {
        return getCurrentSesion().createQuery("select r from Room r where r.hotel.id=:id")
                .setParameter("id", id)
                .list();
    }

    @Override
    public List<Room> getAllHotelRoomsWithBookings(int id) {
        return getCurrentSesion().createQuery("select r from Room r left join fetch r.bookings " +
                "where r.hotel.id=:id")
                .setParameter("id", id)
                .list();
    }
}
