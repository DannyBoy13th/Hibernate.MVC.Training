package ua.goit.java.spring.mvc.dao;

import ua.goit.java.spring.mvc.model.Employee;

import java.util.List;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public interface EmployeeDao {
    void save(Employee employee);

    Employee getEmployee(Long id);

    List<Employee> findAllEmployees();

    Employee findByName(String name);

    void remove(Employee employee);
}
