package com.hotel.hotel_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel_management.dto.BranchRequest;
import com.hotel.hotel_management.dto.BranchResponse;
import com.hotel.hotel_management.service.BranchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping
    public List<BranchResponse> getAllBranches() {
        return branchService.getAllBranches();
    }   

    @GetMapping("/{id}")
    public BranchResponse getBranch(@PathVariable Long id) {
        return branchService.getBranch(id);
    }

    @PostMapping
    public BranchResponse createBranch(BranchRequest request) {
        return branchService.createBranch(request);
    }

    @PutMapping("/{id}")
    public BranchResponse updateBranch(@PathVariable Long id, BranchRequest request) {
        return branchService.updateBranch(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
    }
}
