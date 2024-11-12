package com.kodiatech.etudiant.manager.features.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
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

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMissingParams(MissingServletRequestParameterException ex) {
        String message = "Paramètre requis manquant: " + ex.getParameterName();
        return ResponseEntity.badRequest().body(message);
    }
}
//ERROR Reponse
//https://www.sfeir.dev/back/comment-bien-gerer-ses-erreur-dans-springboot/