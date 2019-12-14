package com.wolfpack.tracker.exceptionhandling;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains custom handling mechanisms
 * for exceptions thrown as a result of API calls
 */
@RestControllerAdvice(annotations = {RestController.class})
public class CustomExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<?> handleConflict(EntityNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();

        Throwable root = NestedExceptionUtils.getMostSpecificCause(exception);

        body.put("cause", root.getMessage());
        body.put("message", exception.getMessage());

        return ResponseEntity.badRequest().body(body);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        if(errors.size() == 0){
            errors.put("Error", "Invalid request format");
        }
        return ResponseEntity.badRequest().body(errors);
    }


}