package com.shashwat.student;

import com.shashwat.student.controller.StudentController;
import com.shashwat.student.entity.Student;
import com.shashwat.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    @Test
    public void shouldReturnStudentById() throws Exception {
        Student mockStud1 = new Student();
        mockStud1.setRollNo(1L);
        mockStud1.setGender("male");
        mockStud1.setStudentName("shashwat");
        mockStud1.setAge(24);
        when(service.getStudentById(1L)).thenReturn(mockStud1);
        this.mockMvc.perform(get("/student/getStudent/1")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnStudentByIdResponse() throws Exception {
        Student mockStud1 = new Student();
        mockStud1.setRollNo(1L);
        mockStud1.setGender("male");
        mockStud1.setStudentName("shashwat");
        mockStud1.setAge(24);
        mockStud1.setCollegeId(1L);
        mockStud1.setCollegeName("College1");
        when(service.getStudentById(1L)).thenReturn(mockStud1);
        this.mockMvc.perform(get("/student/getStudent/1")).andExpect(status().isOk()).andExpect(content().json("{" +
                "    \"rollNo\": 1," +
                "    \"studentName\": \"shashwat\"," +
                "    \"collegeId\": 1,\n" +
                "    \"collegeName\": \"College1\",\n" +
                "    \"age\": 24,\n" +
                "    \"gender\": \"male\"\n" +
                "}"));
    }

    @Test
    public void shouldThrowExceptionIfStudentNotFound() throws Exception {
        when(service.getStudentById(7L)).thenThrow(new NoSuchElementException());
        this.mockMvc.perform(get("/student/getStudent/7")).andDo(print()).andExpect(status().is(404));
    }

}
