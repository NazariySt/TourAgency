package com.softserve.academy.services;

import com.softserve.academy.model.Country;

import java.util.List;

public interface CountryService {

    void save(Country country);

    Country getOne(int id);

    List<Country> getAll();

    void update(int id, String name);

    void delete(int id);
}
