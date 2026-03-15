package com.hotel.hotel_management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hotel.hotel_management.dto.CakeOrderRequest;
import com.hotel.hotel_management.dto.CakeOrderResponse;
import com.hotel.hotel_management.model.Branch;
import com.hotel.hotel_management.model.CakeOrder;
import com.hotel.hotel_management.repository.BranchRepository;
import com.hotel.hotel_management.repository.CakeOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CakeOrderService {
    private final CakeOrderRepository orderRepository;
    private final BranchRepository branchRepository;

    public CakeOrderResponse createOrder(CakeOrderRequest request){
        Branch branch = branchRepository.findById(request.getBranchId()).orElseThrow(() -> new RuntimeException("Branch not found"));

        CakeOrder order = CakeOrder.builder() 
        .cakeType(request.getCakeType()) 
        .weight(request.getWeight()) 
        .messageOnCake(request.getMessageOnCake()) 
        .pickupDate(LocalDate.parse(request.getPickupDate())) 
        .pickupTime(request.getPickupTime()) 
        .customerPhone(request.getCustomerPhone()) 
        .status("PENDING") 
        .branch(branch) 
        .build(); 

        CakeOrder saved = orderRepository.save(order); 
        return mapToDto(saved);
    }

    public List<CakeOrderResponse> getOrders(Long branchId){
        return orderRepository.findByBranchId(branchId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public CakeOrderResponse updateStatus(Long id, String status){
        CakeOrder order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        CakeOrder updated = orderRepository.save(order);
        return mapToDto(updated);
    }

    private CakeOrderResponse mapToDto(CakeOrder order) { 
        return CakeOrderResponse.builder() 
        .id(order.getId()) 
        .cakeType(order.getCakeType()) 
        .weight(order.getWeight()) 
        .pickupDate(order.getPickupDate().toString()) 
        .pickupTime(order.getPickupTime()) 
        .status(order.getStatus()) 
        .customerPhone(order.getCustomerPhone()) 
        .branchId(order.getBranch().getId()) 
        .build(); 
    }
}
