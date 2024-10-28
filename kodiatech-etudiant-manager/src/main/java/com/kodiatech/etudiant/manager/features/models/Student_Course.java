package com.kodiatech.etudiant.manager.features.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table
@Entity(name="student_course")
public class Student_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="student_id")
    private int studentId;

    @Column(name="course_id")
    private int courseId;

}
