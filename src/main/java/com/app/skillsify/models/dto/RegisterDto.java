package com.app.skillsify.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {
    String fullName;
    Date dateOfBirth;
    String phoneNumber;
    String address;
    String email;
    String password;
}
