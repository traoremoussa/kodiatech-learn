package com.kodiatech.etudiant.manager.features.exceptions;


import com.kodiatech.etudiant.manager.features.messagemodel.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ManagerEtudiantNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(ManagerEtudiantNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ManagerBadRequetException.class)
    public ResponseEntity<String> handleStudentNotFoundException(ManagerBadRequetException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    /*** Les excetion par defaut */


    @ExceptionHandler(IllegalArgumentException.class) // Gérer les IllegalArgumentException
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Renvoie un statut 400
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    //MissingServletRequestParameterException
    // Handling NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {

        ErrorResponse error = ErrorResponse.builder()
                .message("Null pointer exception occurred!")
                .details(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(System.currentTimeMillis())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handling MethodArgumentNotValidException

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        String errorMessages = errors.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return new ResponseEntity<>("Validation failed: " + errorMessages, HttpStatus.BAD_REQUEST);


    }
}
//ERROR Reponse
//https://www.sfeir.dev/back/comment-bien-gerer-ses-erreur-dans-springboot/