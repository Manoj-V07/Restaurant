package com.hotel.hotel_management.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.hotel.hotel_management.dto.BookingRequestDTO;
import com.hotel.hotel_management.model.Branch;
import com.hotel.hotel_management.model.HallBookingRequest;
import com.hotel.hotel_management.repository.BranchRepository;
import com.hotel.hotel_management.repository.HallBookingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final HallBookingRepository bookingRepository;
    private final BranchRepository branchRepository;

    public HallBookingRequest createBookingRequest(BookingRequestDTO request){
        Branch branch = branchRepository.findById(request.getBranchId())
                .orElseThrow(() -> new RuntimeException("Branch not found with id: " + request.getBranchId()));

        HallBookingRequest bookingRequest = HallBookingRequest.builder()
                .customerName(request.getCustomerName())
                .phone(request.getPhone())
                .bookingDate(LocalDate.parse(request.getBookingDate()))
                .timeSlot(request.getTimeSlot())
                .branch(branch)
                .build();
        return bookingRepository.save(bookingRequest);
    }
}
