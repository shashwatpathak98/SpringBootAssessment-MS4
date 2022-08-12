package com.shashwat.student.error;

import com.shashwat.student.entity.Student;
import lombok.Data;

import java.util.Date;

@Data
public class StudentError {
    private int status;
    private String message;
    private long timestamp;

    public StudentError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date().getTime();
    }
}
