package com.kodiatech.etudiant.manager.features.service.impl;

import com.kodiatech.etudiant.manager.features.models.Evaluation;
import com.kodiatech.etudiant.manager.features.repository.EvaluationRepository;
import com.kodiatech.etudiant.manager.features.service.IEvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EvaluationServiceImpl implements IEvaluationService {

    private final EvaluationRepository evaluationRepository;

    public double calculerMoyenne(Long etudiantId, Long matiereId) {
        List<Evaluation> evaluations =null;//= evaluationRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        // Calculer la moyenne
        return evaluations.stream().mapToDouble(Evaluation::getNote).average().orElse(0);
    }
}
