/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBoot.Service;

import com.example.SpringBoot.CustomException.NotFoundException;
import com.example.SpringBoot.DTO.CSubjectDTO;
import com.example.SpringBoot.DTOConverter;
import com.example.SpringBoot.Entity.Course;
import com.example.SpringBoot.Entity.Student;
import com.example.SpringBoot.Entity.CSubject;
import com.example.SpringBoot.Repository.SubjectRepository;
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
public class SubjectService {

    @Autowired
    private SubjectRepository repository;
    @Autowired
    private DTOConverter dtoConverter;

    public CSubjectDTO saveSubject(CSubjectDTO subjectDto) {
        CSubject subject = dtoConverter.subjectDtoToCSubject(subjectDto);
        subject = this.repository.save(subject);
        return (dtoConverter.subjectToCSubjectDto(subject));
    }

    public Set<CSubjectDTO> getSubjects() {
        Set<CSubject> subjects = new HashSet<>();
        Set<CSubjectDTO> subjectDto = new HashSet<>();
        subjects.addAll(repository.findAll());
        if (!subjects.isEmpty()) {
            subjectDto.addAll(dtoConverter.subjectToCSubjectDtoList(subjects));
            return subjectDto;
        } else {
            throw new NotFoundException("Subject Not Found");
        }
    }

    public CSubjectDTO getSubjectById(long id) {
        CSubject subject = repository.findById(id).orElse(null);
        if (subject != null) {
            CSubjectDTO subjectDto = dtoConverter.subjectToCSubjectDto(subject);
            return subjectDto;
        } else {
            throw new NotFoundException("subject Not Found");

        }
    }

    public Map<String, String> deleteSubject(long id) {
//        CSubject subject = this.repository.findById(id).orElse(null);
//        Set<Course> courses =subject.getCourses();
//        for(Course course:courses){
//            course.getSubjects().remove(subject);
//        }
//        System.out.println(subject);
//        subject.getCourses().removeAll(courses);
//        repository.delete(subject);
        this.repository.deleteById(id);
        Map<String, String> map = new HashMap<>();
        map.put("Message", "Deleted" + id);
        return map;
    }
}
