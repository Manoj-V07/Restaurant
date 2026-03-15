package com.hotel.hotel_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel_management.dto.CakeOrderRequest;
import com.hotel.hotel_management.dto.CakeOrderResponse;
import com.hotel.hotel_management.service.CakeOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cake-orders")
@RequiredArgsConstructor
public class CakeOrderController {
    private final CakeOrderService cakeOrderService;

    @PostMapping
    public CakeOrderResponse createOrder(@RequestBody CakeOrderRequest request) {
        return cakeOrderService.createOrder(request);
    }

    @GetMapping("/branch/{branchId}")
    public List<CakeOrderResponse> getOrders(@PathVariable Long branchId) {
        return cakeOrderService.getOrders(branchId);
    }

    @PutMapping("/{id}/status")
    public CakeOrderResponse updateStatus(@PathVariable Long id, @RequestBody String status) {
        return cakeOrderService.updateStatus(id, status);
    }
}
