package com.softserve.academy.ourDAO;

public abstract class AbstractDaoPattern<Entity , Key extends Number> implements DAO<Entity , Key> {

    public Class<Entity> ourClass;

    public void setOurClass(Class<Entity> ourClass) {
        this.ourClass = ourClass;
    }
}
