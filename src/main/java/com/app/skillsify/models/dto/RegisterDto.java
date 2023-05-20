package com.app.skillsify.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {
    String firstName;
    String lastName;
    String gender;
    Date dateOfBirth;
    String nationality;
    String address;
    String phoneNumber;
    String email;
    String password;
}
