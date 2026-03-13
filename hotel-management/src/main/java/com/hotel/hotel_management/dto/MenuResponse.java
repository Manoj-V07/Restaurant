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
public class MenuResponse {
    private Long id;
    private String itemName; 
    private String category; 
    private Double price; 
    private String imageUrl;
    private Boolean isAvailable; 
    private Long branchId;
}
