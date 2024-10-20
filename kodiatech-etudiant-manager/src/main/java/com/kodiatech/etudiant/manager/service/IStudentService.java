package com.kodiatech.etudiant.manager.service;

import com.kodiatech.etudiant.manager.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStudentService {
    public List<Student> getStudents();
}
