package com.shashwat.college.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long rollNo;
    private String studentName;
    private Long collegeId;
    private String stream;
    private String collegeName;
    private Integer age;
    private String gender;
}