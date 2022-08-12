package com.shashwat.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    private Long collegeId;
    private String collegeName;
    private Integer numStudents;
}
