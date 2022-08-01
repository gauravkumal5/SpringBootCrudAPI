/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Service;

import com.example.SpringBoot.CustomException.NotFoundException;
import com.example.SpringBoot.DTO.CourseDTO;
import com.example.SpringBoot.DTO.CourseStudentDTO;
import com.example.SpringBoot.DTO.CourseSubjectDTO;
import com.example.SpringBoot.DTO.StudentDTO;
import com.example.SpringBoot.DTOConverter;
import com.example.SpringBoot.Entity.CSubject;
import com.example.SpringBoot.Entity.Course;
import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Repository.CourseRepository;
import com.example.SpringBoot.Repository.StudentRepository;
import com.example.SpringBoot.Repository.SubjectRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sks
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private DTOConverter dtoConverter;

    public CourseDTO saveCourse(CourseDTO courseDto) {
        Course course = dtoConverter.courseDtoToCourse(courseDto);
        course = repository.save(course);
        return (dtoConverter.courseToCourseDto(course));
    }

    public Set<CourseDTO> getCourses() {
        Set<Course> courses = new HashSet<>();
        Set<CourseDTO> courseDto = new HashSet<>();
        courses.addAll(repository.findAll());
        if (!courses.isEmpty()) {
            courseDto.addAll(dtoConverter.courseToCourseDtoList(courses));
            return courseDto;
        } else {
            throw new NotFoundException("Course Not Found");
        }
    }

    public CourseDTO getCourseById(long id) {
        Course course = repository.findById(id).orElse(null);
        if (course != null) {
            CourseDTO courseDto = dtoConverter.courseToCourseDto(course);
            return courseDto;
        } else {
            throw new NotFoundException("Course Not Found");

        }
    }

    public Map<String, String> deleteCourse(long id) {
        Course course = this.repository.findById(id).orElse(null);
        Set<Student> students = course.getStudent();
        for (Student student : students) {
            student.getCourses().remove(course);
        }
        System.out.println(course);
        course.getStudent().removeAll(students);
        repository.delete(course);
        Map<String, String> map = new HashMap<>();
        map.put("Message", "Deleted" + id);
        return map;
    }
//    courseSubject

    public CourseSubjectDTO saveCourseSubject(CourseSubjectDTO subjectDto) {
        try {
            Course course = dtoConverter.courseSubjectDtoToCourseSubject(subjectDto);
            System.out.println(course);
            Set<Course> courses = new HashSet<>();
            courses.add(course);
            boolean toBeSaved = false;
            for (CSubject subject : course.getSubjects()) {
                Long subjectId = subject.getId();
                System.out.println("1st id" + subjectId);
                if (subjectId > 0) {
                    subject = subjectRepository.findById(subject.getId()).orElse(null);
                    System.out.println("2nd course " + subject);
                    System.out.println(course);
                    subject.setCourse(course);
                    toBeSaved = true;

                } else {
                    throw new NotFoundException("Subject Not Found");
                }

            }
            if (toBeSaved) {
                course = repository.save(course);
                return (dtoConverter.courseSubjectToCourseSubjectDto(course));

            }
        } catch (NotFoundException e) {
            System.out.println(e);
            throw new NotFoundException("Subject Not Found");

        } catch (Exception e) {
            System.out.println(e);
            throw new NotFoundException("Subject Not Found");

        }
        return null;
    }
}
