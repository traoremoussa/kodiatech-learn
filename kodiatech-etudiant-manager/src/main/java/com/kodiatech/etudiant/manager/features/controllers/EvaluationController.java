package com.kodiatech.etudiant.manager.features.controllers;

import com.kodiatech.etudiant.manager.features.service.IEvaluationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {


    private final IEvaluationService evaluationService;

    public EvaluationController(IEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping("/moyenne/{studentId}/{courseId}")
    public ResponseEntity<Double> getMoyenne(@PathVariable Long studentId, @PathVariable Long courseId) {
        double moyenne = evaluationService.calculerMoyenne(studentId, courseId);
        return ResponseEntity.ok(moyenne);
    }
}
