package com.example.roomcleaningsystem.Services;

import com.example.roomcleaningsystem.Entity.Student;
import com.example.roomcleaningsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
