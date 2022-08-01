/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Repository;

import com.example.SpringBoot.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sks
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
    
}
