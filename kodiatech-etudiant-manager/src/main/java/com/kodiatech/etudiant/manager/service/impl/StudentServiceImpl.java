package com.kodiatech.etudiant.manager.service.impl;

import com.kodiatech.etudiant.manager.models.Student;
import com.kodiatech.etudiant.manager.repository.StudentRepository;
import com.kodiatech.etudiant.manager.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return List.of(new Student("etu1","eut12","mail@gmai.com","070808") );
    }
}
