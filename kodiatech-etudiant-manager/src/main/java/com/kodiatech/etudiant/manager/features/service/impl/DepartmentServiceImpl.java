package com.kodiatech.etudiant.manager.features.service.impl;

import com.kodiatech.etudiant.manager.features.model.Department;
import com.kodiatech.etudiant.manager.features.repository.DepartmentRepository;
import com.kodiatech.etudiant.manager.features.service.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> findAllDepartement(){
        Iterable<Department> departments = departmentRepository.findAll();
        return StreamSupport.stream(departments.spliterator(), false)
                .collect(Collectors.toList());
    }
}