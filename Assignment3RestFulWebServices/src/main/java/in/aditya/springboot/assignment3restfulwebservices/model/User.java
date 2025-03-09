package in.aditya.springboot.assignment3restfulwebservices.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserFilter")
public class User extends RepresentationModel<User> {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private String password;

    public User(Integer id, String name, LocalDate birthDate, String password) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.password = password;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}