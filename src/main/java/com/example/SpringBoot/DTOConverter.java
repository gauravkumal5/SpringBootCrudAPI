/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot;

import com.example.SpringBoot.DTO.CourseDTO;
import com.example.SpringBoot.DTO.CourseStudentDTO;
import com.example.SpringBoot.DTO.StudentDTO;
import com.example.SpringBoot.DTO.CSubjectDTO;
import com.example.SpringBoot.DTO.CourseSubjectDTO;
import com.example.SpringBoot.Entity.Course;
import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Entity.CSubject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author sks
 */
@Component
public class DTOConverter {

    //student
    public StudentDTO studentToStudentDto(Student student) {
        StudentDTO studentDto = new StudentDTO();
        studentDto.setId(student.getId());
        studentDto.setAddress(student.getAddress());
        studentDto.setName(student.getName());
        return studentDto;
    }

    public Set<StudentDTO> studentToStudentDtoList(Set<Student> student) {
        return student.stream().map(x -> studentToStudentDto(x)).collect(Collectors.toSet());
    }

    public Student studentDtoToStudent(StudentDTO studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setAddress(studentDto.getAddress());
        student.setName(studentDto.getName());
        return student;
    }

    public Set<Student> studentDtoToStudentList(Set<StudentDTO> studentDto) {
        return studentDto.stream().map(x -> studentDtoToStudent(x)).collect(Collectors.toSet());
    }

    //course
    public Course courseDtoToCourse(CourseDTO courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setCourseName(courseDto.getCourseName());
        return course;
    }

    public Set<Course> courseDtoToCourseList(Set<CourseDTO> courseListDto) {
        return courseListDto.stream().map(x -> courseDtoToCourse(x)).collect(Collectors.toSet());
    }

    public CourseDTO courseToCourseDto(Course course) {
        CourseDTO courseDto = new CourseDTO();
        courseDto.setId(course.getId());
        courseDto.setCourseName(course.getCourseName());
        return courseDto;
    }

    public Set<CourseDTO> courseToCourseDtoList(Set<Course> courseList) {
        return courseList.stream().map(x -> courseToCourseDto(x)).collect(Collectors.toSet());
    }

    //courseStudent
    public Student courseStudentDtoToCourseStudent(CourseStudentDTO courseStudentDto) {
        Student student = new Student();
        student.setId(courseStudentDto.getId());
        student.setAddress(courseStudentDto.getAddress());
        student.setName(courseStudentDto.getName());
        Set<Course> courseList = courseDtoToCourseList(courseStudentDto.getCourses());
        student.setCourses(courseList);
        return student;
    }

    public CourseStudentDTO studentToCourseStudentDto(Student student) {
        CourseStudentDTO courseStudentDto = new CourseStudentDTO();
        courseStudentDto.setId(student.getId());
        courseStudentDto.setAddress(student.getAddress());
        courseStudentDto.setName(student.getName());
        Set<CourseDTO> courseDtoList = courseToCourseDtoList(student.getCourses());
        courseStudentDto.setCourses(courseDtoList);
        return courseStudentDto;
    }

//    Subjects
    public CSubject subjectDtoToCSubject (CSubjectDTO subjectDto) {
        CSubject subject = new CSubject();
        subject.setId(subjectDto.getId());
        subject.setSubjectName(subjectDto.getSubjectName());
        return subject;
    }

    public Set<CSubject> subjectDtoToCSubjectList(Set<CSubjectDTO> subjectListDto) {
        return subjectListDto.stream().map(x -> subjectDtoToCSubject(x)).collect(Collectors.toSet());
    }

    public CSubjectDTO subjectToCSubjectDto(CSubject subject) {
        CSubjectDTO subjectDto = new CSubjectDTO();
        subjectDto.setId(subject.getId());
        subjectDto.setSubjectName(subject.getSubjectName());
        return subjectDto;
    }

    public Set<CSubjectDTO> subjectToCSubjectDtoList(Set<CSubject> subjectList) {
        return subjectList.stream().map(x -> subjectToCSubjectDto(x)).collect(Collectors.toSet());
    }
    
     public Course courseSubjectDtoToCourseSubject(CourseSubjectDTO courseSubjectDto) {
        Course course = new Course();
        course.setId(courseSubjectDto.getId());
        course.setCourseName(courseSubjectDto.getCourseName());
        Set<CSubject> subjectList = subjectDtoToCSubjectList(courseSubjectDto.getSubjects());
        course.setSubjects(subjectList);
        return course;
    }

    public CourseSubjectDTO courseSubjectToCourseSubjectDto(Course course) {
        CourseSubjectDTO courseSubjectDto = new CourseSubjectDTO();
        courseSubjectDto.setId(course.getId());
        courseSubjectDto.setCourseName(course.getCourseName());
        Set<CSubjectDTO> subjectDtoList =subjectToCSubjectDtoList(course.getSubjects());
        courseSubjectDto.setSubjects(subjectDtoList);
        return courseSubjectDto;
    }


}
