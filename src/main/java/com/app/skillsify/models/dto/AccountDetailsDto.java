package com.app.skillsify.models.dto;

import java.util.Date;


public record AccountDetailsDto (
    String firstName,
    String lastName,
    String email,
    String username,
    Date dateOfBirth,
    String nationality,
    String address,
    String phoneNumber
    ){
}
