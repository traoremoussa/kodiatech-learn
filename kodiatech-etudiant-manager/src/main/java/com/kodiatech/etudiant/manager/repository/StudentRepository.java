package com.kodiatech.etudiant.manager.repository;

import com.kodiatech.etudiant.manager.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository <Student, Long>{
}
