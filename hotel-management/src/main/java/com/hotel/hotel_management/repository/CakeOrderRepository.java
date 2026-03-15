package com.hotel.hotel_management.repository;

import com.hotel.hotel_management.model.CakeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CakeOrderRepository extends JpaRepository<CakeOrder, Long> {
    List<CakeOrder> findByBranchId(Long branchId);
}
