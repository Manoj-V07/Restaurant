package com.hotel.hotel_management.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.hotel_management.dto.LoginRequest;
import com.hotel.hotel_management.model.Employee;
import com.hotel.hotel_management.repository.EmployeeRepository;
import com.hotel.hotel_management.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final EmployeeRepository employeeRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public String login(LoginRequest request){
        Employee employee = employeeRepository.findByEmail(request.getEmail()).orElseThrow();
        if(!passwordEncoder.matches(request.getPassword(), employee.getPasswordHash())){
            throw new RuntimeException("Invalid credentials");
        }
        if(!employee.getIsApproved()){
            throw new RuntimeException("Employee not approved");
        }
        return jwtUtil.generateToken(employee.getEmail());
    }
}
