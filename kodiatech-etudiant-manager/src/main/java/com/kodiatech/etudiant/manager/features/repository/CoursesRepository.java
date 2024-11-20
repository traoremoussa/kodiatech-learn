package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository  extends CrudRepository<Course, Long> {

}
