/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.DTO;

import com.example.SpringBoot.Entity.Course;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author sks
 */
public class StudentDTO {

    @NotNull(message = "Id cannot be null")
    private long id;
    @NotEmpty(message = "Cannot be Empty")
    @Size(min = 2, max = 10, message = "user name should have at least 2 characters")
    private String name;
    @NotNull(message = "Cannot be null")
    private String address;


    public StudentDTO() {
    }

    public StudentDTO(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

}
