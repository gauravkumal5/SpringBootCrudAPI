/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Service;

import com.example.SpringBoot.CustomException.NotFoundException;
import com.example.SpringBoot.DTO.CourseStudentDTO;
import com.example.SpringBoot.DTO.StudentDTO;
import com.example.SpringBoot.DTOConverter;
import com.example.SpringBoot.Entity.Course;
import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Repository.CourseRepository;
import com.example.SpringBoot.Repository.StudentRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sks
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DTOConverter dtoConverter;

    public StudentDTO saveStudent(StudentDTO studentDto) {

        try {
            Student student = dtoConverter.studentDtoToStudent(studentDto);
            student = repository.save(student);
            return (dtoConverter.studentToStudentDto(student));

        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public CourseStudentDTO saveCourseStudent(CourseStudentDTO studentDto) {
        try {
            Student student = dtoConverter.courseStudentDtoToCourseStudent(studentDto);
            System.out.println(student);
            Set<Student> students = new HashSet<>();
            students.add(student);
            boolean toBeSaved = false;
            for (Course course : student.getCourses()) {
                Long courseId = course.getId();
                System.out.println("id" + courseId);
                if (courseId > 0) {
                    course = courseRepository.findById(course.getId()).orElse(null);
                    System.out.println("course " + course);
                    System.out.println(course);
                    course.setStudent(students);
                    toBeSaved = true;
                } else {
                    throw new NotFoundException("Courses Not Found");

                }

                if (toBeSaved) {
                    student = repository.save(student);
                }
            }
            return (dtoConverter.studentToCourseStudentDto(student));
        } catch (NotFoundException e) {
            System.out.println(e);
            throw new NotFoundException("Courses Not Found");

        }
    }

    public Set<StudentDTO> getStudents() {
       try{
            Set<Student> students = new HashSet<>();
        Set<StudentDTO> studentsDto = new HashSet<>();
        students.addAll(repository.findAll());
        if (!students.isEmpty()) {
            studentsDto.addAll(dtoConverter.studentToStudentDtoList(students));
            return studentsDto;
        } else {
            throw new NotFoundException("Students Not Found");
        }
        
       }
       catch(Exception e){
           throw new NotFoundException("Students Not Found");
       }
    }

    public StudentDTO getStudentById(long id) {
        Student student = repository.findById(id).orElse(null);
        if (student != null) {
            StudentDTO studentDto = dtoConverter.studentToStudentDto(student);
            return studentDto;
        } else {
            throw new NotFoundException("Student Not Found");

        }

    }

    public StudentDTO getStudentByName(String name) {
        Student student = (Student) repository.searchByName(name);
        if (student != null) {
            StudentDTO studentDto = dtoConverter.studentToStudentDto(student);
            return studentDto;
        } else {
            throw new NotFoundException("Student Not Found");

        }

    }

    public Map<String, String> deleteStudent(long id) {
        repository.deleteById(id);
        Map<String, String> map = new HashMap<>();
        map.put("Message", "Deleted" + id);
        return map;
    }

}
