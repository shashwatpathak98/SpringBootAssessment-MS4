package com.shashwat.college.controller;

import com.shashwat.college.entity.College;
import com.shashwat.college.services.CollegeService;
import com.shashwat.college.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    public CollegeService service;

    @PostMapping("/saveCollege")
    public College saveCollege(@RequestBody College college) {
        return service.saveCollege(college);
    }

    @GetMapping("/getCollege/{collId}")
    public College getCollegeById(@PathVariable Long collId) {
        return service.getCollegeById(collId);
    }

    @GetMapping("/getCollegeAndStudents/{collId}")
    public ResponseTemplateVO getCollegeAndStudents(@PathVariable Long collId) {
        return service.getAllCollegeInfo(collId);
    }

    @GetMapping("/getAllCollegeAndStudents")
    public List<ResponseTemplateVO> getAllCollegeAndStudents() {
        return service.getAllCollegesInfo();
    }
}
