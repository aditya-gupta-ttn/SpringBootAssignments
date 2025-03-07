package in.aditya.springboot.assignment2restfulwebservices.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Employee Not Found Exception
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>("Employee not found with "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle Generic Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)  // Extract only message
                .collect(Collectors.toList());

        return new ResponseEntity<>(errors.get(0), HttpStatus.BAD_REQUEST); // Return only first error message
    }
}

