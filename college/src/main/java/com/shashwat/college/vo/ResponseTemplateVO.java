package com.shashwat.college.vo;

import com.shashwat.college.entity.College;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
    private List<Student> students;
    private College college;
}
