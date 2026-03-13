package com.hotel.hotel_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel_management.dto.MenuRequest;
import com.hotel.hotel_management.dto.MenuResponse;
import com.hotel.hotel_management.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/branch/{branchId}")
    public List<MenuResponse> getMenuByBranchId(@PathVariable Long branchId){
        return menuService.getMenu(branchId);
    }

    @PostMapping
    public MenuResponse createMenuItem(@RequestBody MenuRequest request){
        return menuService.createMenuItem(request);
    }

    @PutMapping("/{id}")
    public MenuResponse updateMenuItem(@PathVariable Long id, @RequestBody MenuRequest request){
        return menuService.updateMenuItem(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id){
        menuService.deleteMenuItem(id);
    }
}
