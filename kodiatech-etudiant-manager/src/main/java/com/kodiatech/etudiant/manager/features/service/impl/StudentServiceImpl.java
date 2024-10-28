package com.kodiatech.etudiant.manager.features.service.impl;

import com.kodiatech.etudiant.manager.features.models.Student;
import com.kodiatech.etudiant.manager.features.repository.StudentRepository;
import com.kodiatech.etudiant.manager.features.service.IStudentService;
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

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteStudent() {

    }
}
