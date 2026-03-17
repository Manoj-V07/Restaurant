package com.hotel.hotel_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.hotel_management.model.PartyHall;

public interface PartyHallRepository extends JpaRepository<PartyHall, Long> {
    List<PartyHall> findByBranchId(Long branchId);
}
