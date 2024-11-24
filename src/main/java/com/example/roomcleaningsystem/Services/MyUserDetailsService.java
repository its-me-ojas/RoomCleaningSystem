package com.example.roomcleaningsystem.Services;

import com.example.roomcleaningsystem.Entity.Student;
import com.example.roomcleaningsystem.Entity.StudentPrincipal;
import com.example.roomcleaningsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = studentRepo.findByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("User 404");
        }
        return new StudentPrincipal(student);
    }
}
