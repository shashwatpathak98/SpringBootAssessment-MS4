package com.shashwat.student.repository;

import com.shashwat.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByCollegeIdOrderByStudentNameAsc(long id);
}
