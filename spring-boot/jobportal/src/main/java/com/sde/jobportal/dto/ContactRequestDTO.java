package com.sde.jobportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.sde.jobportal.entity.Contact}
 */
public record ContactRequestDTO(
        @NotBlank(message = "Email can not be empty")
        @Email
        String email,
        @NotBlank(message = "Message can not be empty")
       @Size(min = 5, max = 500, message = "Message must be between 5 and 500 characters")
        String message,

        @NotBlank(message = "Name can not be empty")
        @Size(min = 5, max = 30, message = "Name must be between 5 and 30 characters")
        String name,

        @NotBlank(message = "Subject can not be empty")
        @Size(min = 5, max = 150, message = "Subject must be between 5 and 150 characters")
        String subject,

        @NotBlank(message = "userType  can not be empty")
        @Pattern(regexp = "Job Seeker|Employer|Other", message = "User Type Must be one of :Job Seeker,Employer,Other ")
        String userType)

        implements Serializable {
}