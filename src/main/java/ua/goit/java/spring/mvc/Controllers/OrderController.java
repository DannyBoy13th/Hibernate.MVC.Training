package ua.goit.java.spring.mvc.Controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.spring.mvc.dao.DishDao;
import ua.goit.java.spring.mvc.dao.EmployeeDao;
import ua.goit.java.spring.mvc.dao.OrderDao;
import ua.goit.java.spring.mvc.model.Dish;
import ua.goit.java.spring.mvc.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public class OrderController {

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber){
        Order order = new Order();
        order.setWaiter(employeeDao.findByName(waiterName));
        order.setDishes(createDishes(dishes));
        order.setTableNumber(tableNumber);
        order.setOrderDate(new Date());
    }

    @Transactional
    public List<Order> getAllOrders(){
        return orderDao.findAllOrders();
    }

    private List<Dish> createDishes(List<String> dishes){
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
