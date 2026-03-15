package com.hotel.hotel_management.model;

import java.time.LocalDate;

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
@Table(name = "cake_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CakeOrder {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
    
    private String cakeType; 
    
    private String weight; 
    
    private String messageOnCake; 
    
    private LocalDate pickupDate; 
    
    private String pickupTime; 
    
    private String customerPhone; 
    
    private String status; 
    
    @ManyToOne 
    @JoinColumn(name = "branch_id") 
    private Branch branch;
}
