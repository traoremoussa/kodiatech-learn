package com.kodiatech.etudiant.manager.controllers;

import com.kodiatech.etudiant.manager.models.Student;
import com.kodiatech.etudiant.manager.repository.StudentRepository;
import com.kodiatech.etudiant.manager.service.IStudentService;
import com.kodiatech.etudiant.manager.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //for rest
public class StudentController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());


    private final  IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping()
    public String hello(){
        return "hello toulouse ok gg";
    }


@GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){

        return ResponseEntity.ok().body(studentService.getStudents());
}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return null;//studentService.saveStudent(student);
    }
}
