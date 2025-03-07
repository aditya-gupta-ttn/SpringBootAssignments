package in.aditya.springboot.assignment2restfulwebservices.controller;




import in.aditya.springboot.assignment2restfulwebservices.model.Employee;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Controller
public class EmployeeController {
    static int counter = 0;
    private static List<Employee> users = new ArrayList<>();
    static {
        users.add(new Employee(++counter,"Addi", 30));
        users.add(new Employee(++counter,"Abhi", 24));
        users.add(new Employee(++counter,"Divi", 36));

    }
    public List<Employee> findAll() {
        return users;
    }
    public Employee findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public Employee save(Employee user) {
        user.setId(++counter);
        users.add(user);
        return user;
    }

    public Employee deleleById(Integer id) {
        Predicate<Employee> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee employee = findById(id);
        employee.setName(updatedEmployee.getName());
        employee.setAge(updatedEmployee.getAge());
        return employee;
    }

}
