package com.kodiatech.etudiant.manager.features.service.impl;

import com.kodiatech.etudiant.manager.features.exceptions.ManagerEtudiantException;
import com.kodiatech.etudiant.manager.features.exceptions.ManagerEtudiantNotFoundException;
import com.kodiatech.etudiant.manager.features.model.Department;
import com.kodiatech.etudiant.manager.features.model.Student;
import com.kodiatech.etudiant.manager.features.repository.DepartmentRepository;
import com.kodiatech.etudiant.manager.features.repository.StudentRepository;
import com.kodiatech.etudiant.manager.features.service.IStudentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Student> getStudents() {
        //return List.of(new Student("etu1","eut12","mail@gmai.com","070808") );
        List<Student> list = new ArrayList<>();
        studentRepository.findAll().forEach(list::add);
        return list;
    }

    public String hello() {
        return "hello toulouse ok gg";
    }


    @Transactional
    @Override

    public Student addStudent(Student student) {
        if (student.getDepartment() != null) {
            // Si l'ID du département n'est pas défini, il n'existe pas encore, donc on doit le sauvegarder
            if (student.getDepartment().getId() != null) {
                // Vérifier si le département existe déjà dans la base de données
                Department department = departmentRepository.findById(student.getDepartment().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Department with id " + student.getDepartment().getId() + " not found"));
                student.setDepartment(department);
            }
        }

        // Sauvegarder l'étudiant (le département sera également sauvegardé si c'est un nouveau département)
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student updateStudent(Long id, Student student) {
        Student studentLoad = studentRepository.findById(id).orElseThrow(() -> new ManagerEtudiantException("not-fund objet"));

        //manytone mais pas obligatoire
        if (student.getDepartment() != null) {

        }
        //many to many
//                if(student.getCourses()!=null){
//
//                }
        return null;
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public Student fetchStudentByid(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ManagerEtudiantNotFoundException("not-fund stdent {} " + id));
    }

    @Override
    public List<Student> fetchStudentByName(String name) {
        List<Student> list = studentRepository.findByLastName(name);
        if (list.isEmpty()) {
            throw new ManagerEtudiantNotFoundException("aucun etudiant n'a ce nom : " + name);
        }
        return list;
    }
}
