package com.shashwat.student.service;

import com.shashwat.student.entity.Student;
import com.shashwat.student.repository.StudentRepository;
import com.shashwat.student.vo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student) {
        College college = restTemplate.getForObject("http://COLLEGE-SERVICE/college/getCollegeIdByName/"+ student.getCollegeName(), College.class);
        student.setCollegeId(college.getCollegeId());
        return repo.save(student);
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).get();
    }

    public List<Student> findByCollegeId(Long id) {
        return repo.findAllByCollegeIdOrderByStudentNameAsc(id);
    }

    public List<Student> findByStream(String stream) {
        return repo.findAllByStreamOrderByAgeDesc(stream);
    }
}
