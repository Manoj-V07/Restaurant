package com.hotel.hotel_management.controller;

import com.hotel.hotel_management.model.HallBookingRequest;
import com.hotel.hotel_management.model.HallSlot;
import com.hotel.hotel_management.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/hall")
@RequiredArgsConstructor
public class HallController {

    private final HallService partyHallService;

    @GetMapping("/slots/{branchId}")
    public List<HallSlot> getSlots(
            @PathVariable Long branchId,
            @RequestParam String date) {

        return partyHallService.getSlots(branchId, LocalDate.parse(date));
    }

    @PostMapping("/request")
    public HallBookingRequest requestBooking(
            @RequestParam Long branchId,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String date,
            @RequestParam String slot) {

        return partyHallService.requestBooking(
                branchId,
                name,
                phone,
                LocalDate.parse(date),
                slot
        );
    }

}
