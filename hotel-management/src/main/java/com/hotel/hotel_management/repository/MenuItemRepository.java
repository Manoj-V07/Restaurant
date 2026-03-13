package com.hotel.hotel_management.repository;

import com.hotel.hotel_management.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByBranchId(Long branchId);
}
