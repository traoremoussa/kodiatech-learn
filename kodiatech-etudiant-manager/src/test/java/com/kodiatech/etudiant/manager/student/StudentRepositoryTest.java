package com.kodiatech.etudiant.manager.student;

import com.kodiatech.etudiant.manager.features.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest ( properties={
	//mets la config de la bdd où tu veux tester imagine yaplusieur bdd
})
@Transactional
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
}
