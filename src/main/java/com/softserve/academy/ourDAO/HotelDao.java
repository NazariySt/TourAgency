package com.softserve.academy.ourDAO;

import com.softserve.academy.model.Hotel;

import java.util.List;

public interface HotelDao extends DAO<Hotel , Integer> {
    List<Hotel> getAllCountryHotels(int id);
}
