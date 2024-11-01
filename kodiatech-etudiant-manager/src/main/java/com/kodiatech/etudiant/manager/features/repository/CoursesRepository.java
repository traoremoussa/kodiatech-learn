package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.models.Course;
import com.kodiatech.etudiant.manager.features.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository  extends CrudRepository<Course, Long> {

}
