package in.aditya.springboot.assignment2restfulwebservices.exception;




public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

