package com.kodiatech.etudiant.manager.features.service.impl;

import com.kodiatech.etudiant.manager.features.exceptions.ManagerEtudiantException;
import com.kodiatech.etudiant.manager.features.exceptions.ManagerEtudiantNotFoundException;
import com.kodiatech.etudiant.manager.features.model.Student;
import com.kodiatech.etudiant.manager.features.repository.StudentRepository;
import com.kodiatech.etudiant.manager.features.service.IStudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        //return List.of(new Student("etu1","eut12","mail@gmai.com","070808") );
        List<Student> list=new ArrayList<>();
         studentRepository.findAll().forEach(list::add);
        return list;
    }

    @Transactional
    @Override
    public Student addStudent( Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student updateStudent(Long id,Student student) {
       Student studentLoad= studentRepository.findById(id).orElseThrow(()-> new ManagerEtudiantException("not-fund objet"));

        //manytone mais pas obligatoire
       if(student.getDepartment()!=null){

            }
        //many to many
                if(student.getCourses()!=null){

                }
        return null;
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public Student fetchStudentByid(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new ManagerEtudiantNotFoundException("not-fund stdent {} "+id));
    }

    @Override
    public List<Student> fetchStudentByName(String name) {
        List<Student>list= studentRepository.findByLastName(name);
        if(list.isEmpty()){
            throw  new ManagerEtudiantNotFoundException("aucun etudiant n'a ce nom : "+name);
        }
        return list;
    }
}
