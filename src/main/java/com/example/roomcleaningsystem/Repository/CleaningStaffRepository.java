package com.example.roomcleaningsystem.Repository;

import com.example.roomcleaningsystem.Entity.CleaningStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningStaffRepository extends JpaRepository<CleaningStaff,Integer> {
}
