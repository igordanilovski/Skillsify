package com.app.skillsify.models.mapper;

import com.app.skillsify.models.User;
import com.app.skillsify.models.dto.AccountDetailsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountDetailsDtoMapper implements Function<User, AccountDetailsDto> {
    private final UserCoursesDtoMapper userCoursesDtoMapper;

    @Override
    public AccountDetailsDto apply(User user) {
        return new AccountDetailsDto(
                user.getFullName(),
                user.getEmail(),
                user.getUsername(),
                user.getDateOfBirth(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getCourses().stream().map(userCoursesDtoMapper).collect(Collectors.toList())
        );
    }
}

