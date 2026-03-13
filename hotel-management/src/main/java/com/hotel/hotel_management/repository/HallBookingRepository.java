package com.hotel.hotel_management.repository;

import com.hotel.hotel_management.model.HallBookingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallBookingRepository extends JpaRepository<HallBookingRequest, Long> {
    
}
