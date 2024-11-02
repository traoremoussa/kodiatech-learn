package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.models.Course;
import com.kodiatech.etudiant.manager.features.models.Evaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationRepository  extends CrudRepository<Evaluation, Long> {
  //  List<Evaluation>  findByEtudiantIdAndMatiereId(@Param("studentId") Long student_id, @Param("courseid") Long course_id);
}
