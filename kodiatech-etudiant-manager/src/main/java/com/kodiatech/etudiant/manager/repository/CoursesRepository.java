package com.kodiatech.etudiant.manager.repository;

import com.kodiatech.etudiant.manager.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository  extends CrudRepository<Course, Long> {
}
