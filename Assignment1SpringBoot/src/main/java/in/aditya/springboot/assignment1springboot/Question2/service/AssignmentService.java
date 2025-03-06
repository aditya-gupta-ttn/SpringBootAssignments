package in.aditya.springboot.assignment1springboot.Question2.service;


import in.aditya.springboot.assignment1springboot.Question2.configuration.AssignmentProperty;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {
    final AssignmentProperty assignmentProperty;

    public AssignmentService(AssignmentProperty assignmentProperty) {
        this.assignmentProperty = assignmentProperty;
    }

    public String getService(){
        return assignmentProperty.getMyProperty() +" this is from service layer";
    }

}