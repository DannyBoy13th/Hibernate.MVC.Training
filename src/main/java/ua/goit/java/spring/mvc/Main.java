package ua.goit.java.spring.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.spring.mvc.Controllers.DishController;
import ua.goit.java.spring.mvc.Controllers.EmployeeController;
import ua.goit.java.spring.mvc.Controllers.OrderController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;
    private OrderController orderController;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start(){
        employeeController.createEmployee1();
        //dishController.createDish();

        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Carbonara");
        dishes1.add("Panacotta");
        orderController.createOrder("Kate", dishes1, 1);

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Risotto");
        dishes2.add("Mushroom Soup");
        orderController.createOrder("Kate", dishes2, 3);

        orderController.getAllOrders().forEach(System.out::println);

        //employeeController.getAllEmployees().forEach(System.out::println);
        //dishController.getAllDishes().forEach(System.out::println);
        //System.out.println(employeeController.getEmployeesByName("Daniel"));
        //System.out.println(dishController.getDishByName("Carbonara"));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
