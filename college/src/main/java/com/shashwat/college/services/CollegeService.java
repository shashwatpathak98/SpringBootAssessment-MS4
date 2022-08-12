package com.shashwat.college.services;

import com.shashwat.college.entity.College;
import com.shashwat.college.repository.CollegeRepository;
import com.shashwat.college.vo.ResponseTemplateVO;
import com.shashwat.college.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    public College saveCollege(College college) {
        return repo.save(college);
    }

    public College getCollegeById(Long collId) {
        return repo.findById(collId).orElse(null);
    }

    public ResponseTemplateVO getAllCollegeInfo(Long id) {
        ResponseTemplateVO response = new ResponseTemplateVO();
        College college = repo.findById(id).orElse(null);
        Student[] students = restTemplate.getForObject("http://STUDENT-SERVICE/student/findAllByCollege/"+ college.getCollegeId(), Student[].class);
        response.setCollege(college);
        List<Student> studentList = Arrays.asList(students);
        studentList.sort((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName()));
        response.setStudents(studentList);

        return response;
    }

    public List<ResponseTemplateVO> getAllCollegesInfo() {
        List<College> college = repo.findAll();
        List<ResponseTemplateVO> response = new ArrayList<>();
        for(College c: college) {
            ResponseTemplateVO innerResponse = new ResponseTemplateVO();
            Student[] students = restTemplate.getForObject("http://STUDENT-SERVICE/student/findAllByCollegeNameSorted/"+ c.getCollegeId(), Student[].class);
            innerResponse.setCollege(c);
            List<Student> studentList = Arrays.asList(students);
            studentList.sort((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName()));
            innerResponse.setStudents(studentList);
            response.add(innerResponse);
        }
        return response;
    }

    public College getCollegeIdByName(String name) {
        College college = repo.findByCollegeName(name);
        return college;
    }
}
