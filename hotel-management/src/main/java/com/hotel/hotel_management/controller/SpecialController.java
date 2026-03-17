package com.hotel.hotel_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel_management.model.SpecialItem;
import com.hotel.hotel_management.repository.SpecialItemRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/specials")
@RequiredArgsConstructor
public class SpecialController {
    private final SpecialItemRepository repository; 
    
    @GetMapping("/{branchId}") 
    public List<SpecialItem> getSpecials(@PathVariable Long branchId) { 
        return repository.findByBranchId(branchId); 
    } 
    
    @PostMapping public SpecialItem createSpecial(@RequestBody SpecialItem item) { 
        return repository.save(item); 
    }
}
