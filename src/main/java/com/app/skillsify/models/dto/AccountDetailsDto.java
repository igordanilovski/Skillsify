package com.app.skillsify.models.dto;

import java.util.Date;


public record AccountDetailsDto (
    String fullName,
    String email,
    String username,
    Date dateOfBirth,
    String address,
    String phoneNumber
    ){
}
