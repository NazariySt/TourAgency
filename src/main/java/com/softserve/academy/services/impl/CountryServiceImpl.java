package com.softserve.academy.services.impl;

import com.softserve.academy.model.Country;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.ourDAO.CountryDao;
import com.softserve.academy.ourDAO.HotelDao;
import com.softserve.academy.services.CountryService;
import com.softserve.academy.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDao countryDao;
    private final HotelDao hotelDao;
    private final HotelService hotelService;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao, HotelDao hotelDao, HotelService hotelService) {
        this.countryDao = countryDao;
        this.hotelDao = hotelDao;
        this.hotelService = hotelService;
    }

    @Override
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    public Country getOne(int id) {
        return countryDao.findOne(id);
    }

    @Override
    public List<Country> getAll() {
        return countryDao.findAll();
    }

    @Override
    public void update(int id, String newName) {
        Country country = new Country();
        country.setName(newName);
        countryDao.save(country);

    }

    @Override
    public void delete(int id) {
        Country country = countryDao.findOne(id);
        for (Hotel hotel : country.getHotels()) {
            hotelService.delete(hotel.getId());
        }
        countryDao.delete(id);
    }
}
