package com.shashwat.college.repository;

import com.shashwat.college.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long>{
    College findByCollegeName(String collegeName);
}
