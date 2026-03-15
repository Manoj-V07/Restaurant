
package com.hotel.hotel_management.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hotel.hotel_management.repository.EmployeeRepository;
import com.hotel.hotel_management.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAutheticationFilter  extends OncePerRequestFilter{
    private final JwtUtil jwtUtil;
    private final EmployeeRepository employeeRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if(header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = header.substring(7);
        String email = jwtUtil.extractEmail(token);
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            var employee = employeeRepository.findByEmail(email).orElse(null);
            if(employee != null){
                var auth = new UsernamePasswordAuthenticationToken(email, null, java.util.List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);    
    }
}