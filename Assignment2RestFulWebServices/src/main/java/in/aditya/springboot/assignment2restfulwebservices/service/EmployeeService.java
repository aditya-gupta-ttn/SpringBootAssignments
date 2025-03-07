package in.aditya.springboot.assignment2restfulwebservices.service;



import in.aditya.springboot.assignment2restfulwebservices.controller.EmployeeController;
import in.aditya.springboot.assignment2restfulwebservices.exception.UserNotFoundException;
import in.aditya.springboot.assignment2restfulwebservices.model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeService {

    private EmployeeController services;



    public EmployeeService(EmployeeController services) {
        this.services = services;
    }

    @GetMapping("/users")
    public List<Employee> retrieveAllUsers() {
        return services.findAll();
    }

    @GetMapping("/users/{id}")
    public Employee findById(@PathVariable Integer id) {
        Employee user = services.findById(id);
        if(user == null) {
            throw new UserNotFoundException("id"+id);
        }
        return user;
    }


    @PostMapping("/users")
    public ResponseEntity<Employee> addUser(@Valid @RequestBody Employee user) {
        Employee savedUser= services.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void DeleteById(@PathVariable Integer id) {
        services.deleleById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @Valid @RequestBody Employee updatedEmployee) {
        return ResponseEntity.ok(services.updateEmployee(id, updatedEmployee));
    }




}