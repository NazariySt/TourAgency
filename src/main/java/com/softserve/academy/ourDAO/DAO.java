package com.softserve.academy.ourDAO;

import java.util.List;

public interface DAO <Entity , Key extends Number>{

    void delete(Key id);

    Entity findOne(Key id);

    List<Entity> findAll();

    void save(Entity entity);

}
