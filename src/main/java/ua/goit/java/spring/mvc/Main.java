package ua.goit.java.spring.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.spring.mvc.Controllers.DishController;
import ua.goit.java.spring.mvc.Controllers.EmployeeController;
import ua.goit.java.spring.mvc.Controllers.OrderController;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public class Main {

    private EmployeeController employeeController;
    private DishController dishController;


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start(){
        employeeController.createEmployee1();
        dishController.createDish();

        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);

        System.out.println(employeeController.getEmployeesByName("Daniel"));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
