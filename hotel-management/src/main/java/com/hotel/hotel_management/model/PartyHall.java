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
@Table(name = "party_halls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartyHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hallName;

    private Integer capactiy;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
