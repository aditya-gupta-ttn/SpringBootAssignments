package in.aditya.springboot.assignment1springboot.Question1and3.services;


import in.aditya.springboot.assignment1springboot.Question1and3.entity.Employee;
import in.aditya.springboot.assignment1springboot.Question1and3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> saveEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}