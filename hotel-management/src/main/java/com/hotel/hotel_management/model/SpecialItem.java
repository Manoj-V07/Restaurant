package com.hotel.hotel_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "special_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialItem {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
    
    private String dayOfWeek; 
    
    private String itemName; 
    
    private Double price; 
    
    @ManyToOne
    @JoinColumn(name = "branch_id") 
    private Branch branch;
}
