package com.example.roomcleaningsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class CleaningStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cleaner_id;
    private String username;
    private String password;
    private String email_id;
    private List<Integer> assigned_rooms;

}
