package ua.goit.java.spring.mvc.dao;

import ua.goit.java.spring.mvc.model.Dish;

import java.util.List;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public interface DishDao {

    void save(Dish dish);

    List<Dish> findAllDishes();

    Dish findByName(String name);

}
