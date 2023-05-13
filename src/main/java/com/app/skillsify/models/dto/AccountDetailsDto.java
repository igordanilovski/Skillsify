package com.app.skillsify.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDetailsDto {
    String firstName;
    String lastName;
    String email;
    String username;
    Date createdAt;
}
