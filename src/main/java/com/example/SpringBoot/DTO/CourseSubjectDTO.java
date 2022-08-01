/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.DTO;

import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sks
 */
public class CourseSubjectDTO {

    @NotNull(message = "Id cannot be null")
    private long id;
    @NotEmpty(message = "Cannot be Empty")
    @Size(min = 2, max = 10, message = "user name should have at least 2 characters")
    private String courseName;
    @NotNull(message = "Cannot be null")

    public Set<@Valid CSubjectDTO> subjects;

    public CourseSubjectDTO() {
    }

    public CourseSubjectDTO(long id, String courseName, Set<CSubjectDTO> subjects) {
        this.id = id;
        this.courseName = courseName;
        this.subjects = subjects;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Set<CSubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<CSubjectDTO> subjects) {
        this.subjects = subjects;
    }

}
