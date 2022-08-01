/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Controller;

import com.example.SpringBoot.DTO.StudentDTO;
import com.example.SpringBoot.DTOConverter;
import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.CustomException.NotFoundException;
import com.example.SpringBoot.DTO.CourseStudentDTO;
import com.example.SpringBoot.Service.StudentService;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author sks
 */
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/")
    public String home() {
        return "Hello World!";

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findStudent(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<StudentDTO> findStudentByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(service.getStudentByName(name), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<Set<StudentDTO>> findAllStudents()throws SQLException {
        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> addStudents(@Valid @RequestBody StudentDTO studentDto) {
        return new ResponseEntity<>(service.saveStudent(studentDto), HttpStatus.OK);
    }
    
     @PostMapping("/postStudentCourse")
    public ResponseEntity<CourseStudentDTO> addCourseStudents(@Valid @RequestBody CourseStudentDTO studentDto) {

        return new ResponseEntity<>(service.saveCourseStudent(studentDto), HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
//        Student st = service.updateStudent(student);
//        if (st != null) {
//            return new ResponseEntity<>(st, HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable long id){
        return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.OK);
    }

}
