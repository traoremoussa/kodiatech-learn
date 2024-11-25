package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
