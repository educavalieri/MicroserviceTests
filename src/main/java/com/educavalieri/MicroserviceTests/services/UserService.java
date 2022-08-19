package com.educavalieri.MicroserviceTests.services;

import com.educavalieri.MicroserviceTests.dtos.UserRequestDto;
import com.educavalieri.MicroserviceTests.dtos.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto insert(UserRequestDto dto);

    List<UserResponseDto> findAll();

    UserResponseDto findById(Long id);

    void delete(Long id);

    UserResponseDto update(UserRequestDto dto);

}
