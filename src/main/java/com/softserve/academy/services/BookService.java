package com.softserve.academy.services;

public interface BookService {
    void bookRoom(int userId , int roomId , String startDate , String endDate);
}
