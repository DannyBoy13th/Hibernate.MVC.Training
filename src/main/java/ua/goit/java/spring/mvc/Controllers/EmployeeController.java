package ua.goit.java.spring.mvc.Controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.spring.mvc.dao.EmployeeDao;
import ua.goit.java.spring.mvc.model.Employee;
import ua.goit.java.spring.mvc.model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public void createEmployee1(){
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAllEmployees());

        Employee chef = new Employee();
        chef.setName("Daniel");
        chef.setSurname("Solo");
        chef.setPosition(Position.CHEF);
        chef.setPhoneNumber("+380631078997");
        chef.setSalary(50000.0F);

        if (!allEmployees.contains(chef)) {
            employeeDao.save(chef);
        }
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAllEmployees();
    }

    @Transactional
    public Employee getEmployeesByName(String name) {
        return employeeDao.findByName(name);
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
