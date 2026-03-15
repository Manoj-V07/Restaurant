package com.hotel.hotel_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CakeOrderRequest {
    private String cakeType; 
    private String weight; 
    private String messageOnCake; 
    private String pickupDate; 
    private String pickupTime; 
    private String customerPhone; 
    private Long branchId;
}
