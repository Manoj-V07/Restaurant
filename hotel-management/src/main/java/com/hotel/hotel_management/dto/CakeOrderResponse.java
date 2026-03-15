package com.hotel.hotel_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CakeOrderResponse {
    private Long id; 
    private String cakeType; 
    private String weight; 
    private String pickupDate; 
    private String pickupTime; 
    private String status;
    private String customerPhone; 
    private Long branchId;
}
