package com.kodiatech.etudiant.manager.features.repository;

import com.kodiatech.etudiant.manager.features.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}

