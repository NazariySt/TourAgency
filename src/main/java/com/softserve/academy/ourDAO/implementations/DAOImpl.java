package com.softserve.academy.ourDAO.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.softserve.academy.ourDAO.AbstractDaoPattern;

import java.util.List;

@Repository
public class DAOImpl<Entity, Key extends Number> extends AbstractDaoPattern<Entity, Key> {

    private final SessionFactory sessionFactory;

    public DAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Entity entity) {
        sessionFactory.getCurrentSession().save(entity);
        sessionFactory.getCurrentSession().flush(); /* Flushing the session forces Hibernate to synchronize the in-memory state of the Session with the db */
    }

    @Override
    public void delete(Key id) {
        sessionFactory.getCurrentSession().createQuery("delete from " + ourClass.getName() + " key where key.id =:id ");

    }

    @Override
    public Entity findOne(Key id) {
        return (Entity) sessionFactory.getCurrentSession()
                .createQuery("select k from " + ourClass.getName() + " k where k.id =:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Entity> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + ourClass.getName()).list();
    }

    public Session getCurrentSesion() {
        return sessionFactory.getCurrentSession();
    }
}
