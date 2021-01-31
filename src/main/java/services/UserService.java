package services;

import model.Order;
import model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User findUserById(Integer userId);

    User findUserByFirstName(String userFirstName);

    List<User> getAllUsers();

    List<Order> getAllOrdersByUserId(Integer userId);


}
