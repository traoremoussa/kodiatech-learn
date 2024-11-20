package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository  extends CrudRepository <Student, Long>{
    List<Student> findByLastName(String name);
}
