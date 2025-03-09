package in.aditya.springboot.assignment3restfulwebservices.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import in.aditya.springboot.assignment3restfulwebservices.model.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController {
    private static  List<User> users = new ArrayList<>();
    static int counter=0;
    static {
        users.add(new User(++counter,"Addi", LocalDate.now().minusYears(30),"@12345"));
        users.add(new User(++counter,"Abhi", LocalDate.now().minusYears(24),"@45678"));
        users.add(new User(++counter,"Divi", LocalDate.now().minusYears(36),"@12345"));

    }


    // Dynamic Filtering
    @GetMapping("/filtered")
    public MappingJacksonValue getFilteredUsers() {
        List<User> filteredUsers = users;
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(filteredUsers);
        mapping.setFilters(filters);

        return mapping;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> createUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping(path = "/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public List<User> getUsersxml() {
        return users;
    }


    //Hateoas
    @GetMapping
    public List<User> getUsers() {
        return users.stream()
                .map(user -> {
                    // 🔗 Add self-link for each user
                    Link selfLink = linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel();
                    user.add(selfLink);
                    return user;
                }).collect(Collectors.toList());
    }


    //Hateoas
    @Operation(summary = "Get user details", description = "Fetch user details by ID")
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        User user = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

        if (user == null) return null;

        Link selfLink = linkTo(methodOn(UserController.class).getUser(id)).withSelfRel();
        Link allUsersLink = linkTo(methodOn(UserController.class).getUsers()).withRel("all-users");
        user.add(selfLink, allUsersLink);
        return user;
    }
}

