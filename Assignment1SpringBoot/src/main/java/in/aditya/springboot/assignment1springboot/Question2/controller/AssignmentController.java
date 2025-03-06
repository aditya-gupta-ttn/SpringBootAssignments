package in.aditya.springboot.assignment1springboot.Question2.controller;


import in.aditya.springboot.assignment1springboot.Question2.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentService service ;

    @GetMapping(value = "/service")
    public String getMessage(){
        return service.getService();
    }
}
