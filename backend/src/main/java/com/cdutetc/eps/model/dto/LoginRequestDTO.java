package com.cdutetc.eps.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class LoginRequestDTO{

    private String Username;
    private String Password;
    
}
