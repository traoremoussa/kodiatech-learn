package com.kodiatech.etudiant.manager.features.controllers;

import com.kodiatech.etudiant.manager.features.exceptions.ManagerBadRequetException;
import com.kodiatech.etudiant.manager.features.models.Course;
import com.kodiatech.etudiant.manager.features.models.Student;
import com.kodiatech.etudiant.manager.features.service.IStudentService;

import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//for rest
@RequestMapping("api/student")
public class StudentController {
    HttpStatus  httpStatus=HttpStatus.OK;
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
        return studentService.addStudent(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> fetchStudent( @PathVariable long id){

        return  new ResponseEntity<Student>(studentService.fetchStudentByid(id),httpStatus);
    }

    @GetMapping("/names")
    public ResponseEntity<List<Student>> fetchStudentsByNames( @RequestParam ("name") String name){

        if (StringUtils.isBlank(name)) {
            throw new ManagerBadRequetException("Le nom de l'étudiant ne peut pas être vide.");
        }
        return  new ResponseEntity<List<Student>>(studentService.fetchStudentByName(name),httpStatus);
    }
    // select etudiant par id et afficher ses note par matiere
    // select liste des cours suivi
    // select le nombre de matiere ou il a la moyen
    // liste des matieres ou il a la moyen
    // liste de classement par matiere
    // liste de classement generale



    @GetMapping("/{student_id}/courses")
    public ResponseEntity<List<Course>> fetchStudentCourses(@PathVariable Long student_id){
        return null;
    }
}
