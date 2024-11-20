package com.kodiatech.etudiant.manager.features.service;

import com.kodiatech.etudiant.manager.features.model.Student;

import java.util.List;


public interface IStudentService {
    public List<Student> getStudents();
    public Student addStudent(Student student);
    public Student updateStudent(Long id, Student student);
    public void deleteStudent();
   public  Student fetchStudentByid(Long id);
    public  List<Student> fetchStudentByName(String name);

}
