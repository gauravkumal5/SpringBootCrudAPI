/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Controller;

import com.example.SpringBoot.DTO.CourseDTO;
import com.example.SpringBoot.DTO.CourseSubjectDTO;
import com.example.SpringBoot.Service.CourseService;
import java.util.Map;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sks
 */
@RestController
@RequestMapping(path = "/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findCourse(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getCourseById(id), HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<Set<CourseDTO>> findAllCourses() {
        return new ResponseEntity<>(service.getCourses(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<CourseDTO> addCourse(@Valid @RequestBody CourseDTO courseDto) {

        return new ResponseEntity<>(service.saveCourse(courseDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable long id) {
        return new ResponseEntity<>(service.deleteCourse(id), HttpStatus.OK);
    }

//    @PostMapping("/postCourseStudent")
//    public ResponseEntity<CourseSubjectDTO> addCourseSubject(@Valid @RequestBody CourseSubjectDTO subjectDto) {
//
//        return new ResponseEntity<>(service.saveCourseSubject(subjectDto), HttpStatus.OK);
//    }
    
    @PostMapping("/postCourseSubject")
        public ResponseEntity<CourseSubjectDTO> addCourseSubjects(@Valid @RequestBody CourseSubjectDTO subjectDto) {

        return new ResponseEntity<>(service.saveCourseSubject(subjectDto), HttpStatus.CREATED);
    }

}

