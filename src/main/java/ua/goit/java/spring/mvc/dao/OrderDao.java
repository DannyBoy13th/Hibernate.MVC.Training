package ua.goit.java.spring.mvc.dao;

import ua.goit.java.spring.mvc.model.Order;

import java.util.List;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public interface OrderDao {

    void save(Order order);

    List<Order> findAllOrders();

}
