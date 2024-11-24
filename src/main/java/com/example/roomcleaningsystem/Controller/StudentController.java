package com.example.roomcleaningsystem.Controller;

import com.example.roomcleaningsystem.Entity.Student;
import com.example.roomcleaningsystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public Student register(@RequestBody Student student) {
        student.setPassword(encoder.encode(student.getPassword()));
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("login")
    public String login(@RequestBody Student student) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(student.getUsername(), student.getPassword()));
        System.out.println("Hello");
        if (authentication.isAuthenticated()) {
            return "Login Success";
        } else {
            return "Login Failed";
        }
    }
}
