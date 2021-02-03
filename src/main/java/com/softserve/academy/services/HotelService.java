package com.softserve.academy.services;

import com.softserve.academy.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotelsInCountry(int id);

    void saveHotel (Hotel hotel , int countryId);

    void delete(int id);

    List<Hotel> getAll();

    void updateHotel(int id, String name, String address, int countryId);

    Hotel getOne(int id);

}
