package com.hotel.hotel_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel_management.model.SpecialItem;

public interface SpecialItemRepository extends JpaRepository<SpecialItem, Long> {
    List<SpecialItem> findByBranchId(Long branchId);
}

