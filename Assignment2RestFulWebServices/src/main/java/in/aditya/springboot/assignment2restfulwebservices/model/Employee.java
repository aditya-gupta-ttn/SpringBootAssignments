package in.aditya.springboot.assignment2restfulwebservices.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Employee{
    private Integer id;

    @NotNull(message = "Name should not be null")
    private String name;

    @Min(value =18, message = "age must be at least 18")
    private Integer age;

    public Employee(Integer id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}
