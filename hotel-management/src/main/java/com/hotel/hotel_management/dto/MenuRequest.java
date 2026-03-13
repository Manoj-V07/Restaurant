package com.hotel.hotel_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRequest {
    private String itemName; 
    private String category; 
    private Double price; 
    private String imageUrl;
    private Boolean isAvailable; 
    private Long branchId;
}
