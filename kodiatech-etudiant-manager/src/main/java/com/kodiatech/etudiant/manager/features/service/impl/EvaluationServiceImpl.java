package com.kodiatech.etudiant.manager.features.service.impl;

import com.kodiatech.etudiant.manager.features.model.Evaluation;
import com.kodiatech.etudiant.manager.features.repository.EvaluationRepository;
import com.kodiatech.etudiant.manager.features.service.IEvaluationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements IEvaluationService {

    private final EvaluationRepository evaluationRepository;
@Transactional
    public double calculerMoyenne(Long etudiantId, Long matiereId) {
        List<Evaluation> evaluations =null;//= evaluationRepository.findByEtudiantIdAndMatiereId(etudiantId, matiereId);
        // Calculer la moyenne
        return evaluations.stream().mapToDouble(Evaluation::getNote).average().orElse(0);
    }
}
