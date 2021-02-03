package com.softserve.academy.ourDAO.implementations;

import com.softserve.academy.model.Order;
import com.softserve.academy.ourDAO.OrderDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends DAOImpl<Order, Integer> implements OrderDao {

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setOurClass(Order.class);
    }
}
