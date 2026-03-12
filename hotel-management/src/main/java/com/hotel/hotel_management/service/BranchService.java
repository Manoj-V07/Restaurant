package com.hotel.hotel_management.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hotel.hotel_management.dto.BranchRequest;
import com.hotel.hotel_management.dto.BranchResponse;
import com.hotel.hotel_management.model.Branch;
import com.hotel.hotel_management.repository.BranchRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public List<BranchResponse> getAllBranches() {
        return branchRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public BranchResponse getBranch(Long id){
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found with id: " + id));
        return mapToDto(branch);
    }

    public BranchResponse createBranch(BranchRequest request){
        Branch branch = Branch.builder().name(request.getName()).location(request.getLocation()).type(request.getType())
                .hasPartyHall(request.getHasPartyHall()).heroImageUrl(request.getHeroImageUrl()).phone(request.getPhone()).build();
        Branch savedBranch = branchRepository.save(branch);
        return mapToDto(savedBranch);
    }

    public BranchResponse updateBranch(Long id, BranchRequest request){
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found with id: " + id));
        branch.setName(request.getName());
        branch.setLocation(request.getLocation());
        branch.setType(request.getType());
        branch.setHasPartyHall(request.getHasPartyHall());
        branch.setHeroImageUrl(request.getHeroImageUrl());
        branch.setPhone(request.getPhone());
        Branch updatedBranch = branchRepository.save(branch);
        return mapToDto(updatedBranch);
    }

    public void deleteBranch(Long id){
        Branch branch = branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found with id: " + id));
        branchRepository.delete(branch);
    }

    private BranchResponse mapToDto(Branch branch){
        return BranchResponse.builder().id(branch.getId()).name(branch.getName()).location(branch.getLocation()).type(branch.getType())
                .hasPartyHall(branch.getHasPartyHall()).heroImageUrl(branch.getHeroImageUrl()).phone(branch.getPhone()).build();
    }
}
