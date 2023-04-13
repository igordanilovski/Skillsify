package com.app.skillsify.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {
    //it's a Data Trasfer Object for registration
    String firstName ;
    String lastName ;
    String email;
    String password ;
}
