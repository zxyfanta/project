package com.cdutetc.eps.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
public class LoginResponseDTO {
    private String token;
}
