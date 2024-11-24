package com.example.roomcleaningsystem.Repository;

import com.example.roomcleaningsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByUsername(String username);
}
