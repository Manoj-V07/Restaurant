package com.hotel.hotel_management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.hotel_management.model.Branch;
import com.hotel.hotel_management.model.HallBookingRequest;
import com.hotel.hotel_management.model.HallSlot;
import com.hotel.hotel_management.repository.BranchRepository;
import com.hotel.hotel_management.repository.HallBookingRepository;
import com.hotel.hotel_management.repository.HallSlotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallSlotRepository slotRepository;
    private final HallBookingRepository bookingRepository;
    private final BranchRepository branchRepository;

    public List<HallSlot> getSlots(Long branchId, LocalDate date){
        return slotRepository.findByBranchIdAndDate(branchId, date);
    }

    public HallBookingRequest requestBooking(Long branchId, String name, String phone, LocalDate date, String slot){
        Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new RuntimeException("Branch not found"));

        HallBookingRequest request = HallBookingRequest.builder()
            .customerName(name)
            .phone(phone)
            .bookingDate(date)
            .timeSlot(slot)
            .status("PENDING")
            .branch(branch)                
            .build();

        return bookingRepository.save(request);
    }

    public void confirmBooking(Long requestId) {

        HallBookingRequest request = bookingRepository.findById(requestId).orElseThrow();

        request.setStatus("CONFIRMED");

        bookingRepository.save(request);

        HallSlot slot = HallSlot.builder()
                .date(request.getBookingDate())
                .timeSlot(request.getTimeSlot())
                .status("BOOKED")
                .branch(request.getBranch())
                .build();

        slotRepository.save(slot);
    }
}
