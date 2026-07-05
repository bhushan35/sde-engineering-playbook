package com.sde.jobportal.dto;

public record LoginResponseDTO(String username, UserDTO user, String jwtToken) {
}
