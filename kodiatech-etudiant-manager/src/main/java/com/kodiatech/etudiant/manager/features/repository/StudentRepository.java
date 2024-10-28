package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository <Student, Long>{
}
