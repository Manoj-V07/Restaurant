package com.hotel.hotel_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDTO {
    private Long branchId;
    private String customerName;
    private String phone;
    private String bookingDate;
    private String timeSlot;
}
