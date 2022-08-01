/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Controller;

/**
 *
 * @author sks
 */
import com.example.SpringBoot.DTO.CSubjectDTO;
import com.example.SpringBoot.DTO.CourseDTO;
import com.example.SpringBoot.Service.CourseService;
import com.example.SpringBoot.Service.SubjectService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService service;

    @GetMapping("/{id}")
    public ResponseEntity<CSubjectDTO> findSubject(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getSubjectById(id),HttpStatus.OK);
    }

    @GetMapping("/subjects")
    public ResponseEntity<Set<CSubjectDTO>> findAllSubjects() {
        return new ResponseEntity<>(service.getSubjects(),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<CSubjectDTO> addSubject(@Valid @RequestBody CSubjectDTO subjectDto) {

        return new ResponseEntity<>(service.saveSubject(subjectDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> deleteSubject(@PathVariable long id) {
        return new ResponseEntity<>(service.deleteSubject(id), HttpStatus.OK);
    }
}
