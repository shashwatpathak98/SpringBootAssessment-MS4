package com.shashwat.student.service;

import com.shashwat.student.entity.Student;
import com.shashwat.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).get();
    }

    public List<Student> findByCollegeId(Long id) {
        return repo.findAllByCollegeIdOrderByStudentNameAsc(id);
    }
}
