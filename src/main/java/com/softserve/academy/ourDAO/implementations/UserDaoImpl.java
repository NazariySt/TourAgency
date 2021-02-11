package com.softserve.academy.ourDAO.implementations;

import com.softserve.academy.model.User;
import com.softserve.academy.ourDAO.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends DAOImpl<User, Integer> implements UserDao {

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setOurClass(User.class);
    }

    @Override
    public User findByName(String login) {
        return (User) getCurrentSession().createQuery("select u from User u where u.emailLogin=:login")
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public User getUserWithBookingsByID(int id) {
        return (User) getCurrentSession()
                .createQuery("select u from User u left join fetch u.bookings where u.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> getAllUsersWithBookings() {
        return getCurrentSession()
                .createQuery("select distinct u from User u left join fetch u.bookings")
                .list();
    }
}
