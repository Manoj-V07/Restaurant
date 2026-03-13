package com.hotel.hotel_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hotel.hotel_management.dto.MenuRequest;
import com.hotel.hotel_management.dto.MenuResponse;
import com.hotel.hotel_management.model.Branch;
import com.hotel.hotel_management.model.MenuItem;
import com.hotel.hotel_management.repository.BranchRepository;
import com.hotel.hotel_management.repository.MenuItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuItemRepository menuRepository;
    private final BranchRepository branchRepository;

    public List<MenuResponse> getMenu(Long branchId){
        return menuRepository.findByBranchId(branchId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public MenuResponse createMenuItem(MenuRequest request){
        Branch branch = branchRepository.findById(request.getBranchId()).orElseThrow(() -> new RuntimeException("Branch not found with id: " + request.getBranchId()));

        MenuItem item = MenuItem.builder().itemName(request.getItemName()).category(request.getCategory()).price(request.getPrice()).imageUrl(request.getImageUrl()).isAvailable(request.getIsAvailable()).branch(branch).build();
        MenuItem savedItem = menuRepository.save(item);
        return mapToDto(savedItem);
    }

    public MenuResponse updateMenuItem(Long id, MenuRequest request){
        MenuItem item = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found with id: " + id));
        Branch branch = branchRepository.findById(request.getBranchId()).orElseThrow(() -> new RuntimeException("Branch not found with id: " + request.getBranchId()));

        item.setItemName(request.getItemName());
        item.setCategory(request.getCategory());
        item.setPrice(request.getPrice());
        item.setImageUrl(request.getImageUrl());
        item.setIsAvailable(request.getIsAvailable());
        item.setBranch(branch);

        MenuItem updatedItem = menuRepository.save(item);
        return mapToDto(updatedItem);
    }

    public void deleteMenuItem(Long id){
        MenuItem item = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found with id: " + id));
        menuRepository.delete(item);
    }

    private MenuResponse mapToDto(MenuItem item){
        return MenuResponse.builder().id(item.getId()).itemName(item.getItemName()).category(item.getCategory()).price(item.getPrice()).imageUrl(item.getImageUrl()).isAvailable(item.getIsAvailable()).branchId(item.getBranch().getId()).build();
    }
}
