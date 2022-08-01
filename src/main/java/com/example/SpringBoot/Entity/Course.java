/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.security.auth.Subject;

/**
 *
 * @author sks
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courseName;
    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Set<Student> student;
    @OneToMany(mappedBy = "course", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE},
             orphanRemoval = true)
    private Set<CSubject> subjects;

    public Course() {

    }

    public Course(long id, String courseName, Set<Student> students, Set<CSubject> subjects) {
        this.id = id;
        this.courseName = courseName;
        this.student = students;
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

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    public Set<CSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<CSubject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", courseName=" + courseName + ", student=" + student + '}';
    }
}
