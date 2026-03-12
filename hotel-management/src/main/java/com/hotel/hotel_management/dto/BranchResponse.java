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
public class BranchResponse {
    private Long id;
    private String name;
    private String location;
    private String type;
    private Boolean hasPartyHall;
    private String heroImageUrl;
    private String phone;

}
