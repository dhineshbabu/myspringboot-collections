package com.performance.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "Firstname should not be empty")
        String firstname,
        @NotEmpty(message = "Lastname should not be empty")
        String lastname,
        @Email
        String email,
        Integer schoolId
) {
}
