package in.aditya.springboot.assignment1springboot.Question1and3.controller;

import in.aditya.springboot.assignment1springboot.Question1and3.entity.Employee;
import in.aditya.springboot.assignment1springboot.Question1and3.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees") // Base URL for all employee-related operations
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor Injection (Best Practice)
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Save multiple employees
    @PostMapping("/save")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveEmployees(employees);
    }

    // Get all employees (optional but useful)
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
