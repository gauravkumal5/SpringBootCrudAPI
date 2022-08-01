/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.DTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author sks
 */
public class CourseStudentDTO {

    @NotNull(message = "Id cannot be null")
    private long id;
    @NotEmpty(message = "Cannot be Empty")
    @Size(min = 2, max = 10, message = "user name should have at least 2 characters")
    private String name;
    @NotNull(message = "Cannot be null")
    private String address;
    @NotEmpty(message = "Cannot be Empty")
    private String contact;

    public Set<@Valid CourseDTO> courses;

    public CourseStudentDTO() {
    }

    public CourseStudentDTO(long id, String name, String address, String contact, Set<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseDTO> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "CourseStudentDTO{" + "id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", courses=" + courses + '}';
    }

}
