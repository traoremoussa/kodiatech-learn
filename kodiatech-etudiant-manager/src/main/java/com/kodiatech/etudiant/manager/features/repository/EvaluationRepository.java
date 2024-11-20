package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.model.Evaluation;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationRepository  extends CrudRepository<Evaluation, Long> {
  //  List<Evaluation>  findByEtudiantIdAndMatiereId(@Param("studentId") Long student_id, @Param("courseid") Long course_id);
}
