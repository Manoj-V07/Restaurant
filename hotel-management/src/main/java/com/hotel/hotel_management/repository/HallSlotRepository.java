package com.hotel.hotel_management.repository;

import com.hotel.hotel_management.model.HallSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HallSlotRepository extends JpaRepository<HallSlot, Long> {
    List<HallSlot> findByBranchIdAndDate(Long branchId, LocalDate date);
}
