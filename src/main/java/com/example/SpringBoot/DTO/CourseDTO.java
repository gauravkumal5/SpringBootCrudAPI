/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sks
 */
public class CourseDTO {

    @NotNull
    private long id;
    @NotEmpty(message = "Cannot be Empty")
    @NotNull
    private String courseName;

    public CourseDTO() {
    }

    public CourseDTO(long id, String courseName) {
        this.id = id;
        this.courseName = courseName;
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

}
