package com.hotel.hotel_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchRequest {
    private String name;
    private String location;
    private String type;
    private Boolean hasPartyHall;
    private String heroImageUrl;
    private String phone;
}
