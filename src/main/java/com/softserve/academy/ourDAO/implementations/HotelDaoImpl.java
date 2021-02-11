package com.softserve.academy.ourDAO.implementations;

import com.softserve.academy.model.Hotel;
import com.softserve.academy.ourDAO.HotelDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl extends DAOImpl<Hotel, Integer> implements HotelDao {


    @Autowired
    public HotelDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setOurClass(Hotel.class);
    }

    @Override
    public List<Hotel> getAllCountryHotels(int id) {
        return getCurrentSession().createQuery("select hotel from Hotel hotel where hotel.country.id=:id")
                .setParameter("id", id)
                .list();
    }
}
