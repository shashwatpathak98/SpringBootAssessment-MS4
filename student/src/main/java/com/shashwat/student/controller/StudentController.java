package com.shashwat.student.controller;

import com.shashwat.student.entity.Student;
import com.shashwat.student.error.StudentError;
import com.shashwat.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) throws Exception {
        return service.saveStudent(student);
    }

    @GetMapping("/getStudent/{studentId}")
    public Student getStudent(@PathVariable Long studentId) {
        return service.getStudentById(studentId);
    }

    @GetMapping("/findAllByCollege/{id}")
    public List<Student> getStudentsByCollege(@PathVariable Long id) {
        List<Student> studs =  service.findByCollegeId(id);
        studs.sort((s1, s2) -> s2.getAge() - s1.getAge());
        return studs;
    }

    @GetMapping("/findAllByCollegeNameSorted/{id}")
    public List<Student> getStudentsByCollegeNameSorted(@PathVariable Long id) {
        List<Student> studs =  service.findByCollegeId(id);
        studs.sort((e1, e2) -> e1.getStudentName().compareTo(e2.getStudentName()));
        return studs;
    }

    @GetMapping("/findStudentsByStream/{stream}")
    public List<Student> getStudentsByStream(@PathVariable String stream) {
        List<Student> students = service.findByStream(stream);
        students.sort((s1, s2) -> s2.getAge() - s1.getAge());
        return students;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StudentError handleNoSuchElementException(NoSuchElementException exception) {
        return new StudentError(404, "Student not found");
    }
}
