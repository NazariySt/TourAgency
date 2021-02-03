package com.softserve.academy.ourDAO.implementations;

import com.softserve.academy.model.Country;
import com.softserve.academy.model.Order;
import com.softserve.academy.ourDAO.CountryDao;
import com.softserve.academy.ourDAO.OrderDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryDaoImpl extends DAOImpl<Country, Integer> implements CountryDao {

    @Autowired
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setOurClass(Country.class);
    }
}
