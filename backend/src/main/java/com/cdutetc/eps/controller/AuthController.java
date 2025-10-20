package com.cdutetc.eps.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdutetc.eps.common.ApiResponse;
import com.cdutetc.eps.utils.JwtTokenUtil;
import com.cdutetc.eps.model.dto.LoginRequestDTO;
import com.cdutetc.eps.model.dto.LoginResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    

    @PostMapping("/login")
    public ApiResponse<LoginResponseDTO> login(@RequestBody LoginRequestDTO lRequestDTO) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(lRequestDTO.getUsername(), lRequestDTO.getPassword()));
        final UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        final String token=jwtTokenUtil.generateToken(userDetails);
        LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
        loginResponseDTO.setToken(token);
        return ApiResponse.success(loginResponseDTO);
    }
}
