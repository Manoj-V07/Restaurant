package com.hotel.hotel_management.repository;

import com.hotel.hotel_management.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    
}
