package com.hotel.hotel_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel_management.dto.BookingRequestDTO;
import com.hotel.hotel_management.model.HallBookingRequest;
import com.hotel.hotel_management.service.BookingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public HallBookingRequest createBooking(@RequestBody BookingRequestDTO request){
        return bookingService.createBookingRequest(request);
    }
}
