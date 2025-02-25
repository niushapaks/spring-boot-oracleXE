package com.example.springjpaoracle.controller;

import java.util.List;
import java.util.Optional;

import com.example.springjpaoracle.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
    @Query(value = "SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.name = ?1 ")
    List<Student> findByNameIgnoreCase(String name);

    @Query(value = "SELECT s FROM Course c INNER JOIN c.students as s WHERE c.name = ?1 ORDER BY s.name ASC")
    List<Student> findStudentsByCoursesNameIgnoreCase(String courseName);

    @Transactional
    void deleteBySocialSecurityNumber(String socialSecurityNumber);

    Optional<Student> findBySocialSecurityNumber(String socialSecurityNumber);
}
