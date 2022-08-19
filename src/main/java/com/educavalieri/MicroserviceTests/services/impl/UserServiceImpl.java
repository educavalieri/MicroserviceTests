package com.educavalieri.MicroserviceTests.services.impl;

import com.educavalieri.MicroserviceTests.dtos.UserRequestDto;
import com.educavalieri.MicroserviceTests.dtos.UserResponseDto;
import com.educavalieri.MicroserviceTests.entities.User;
import com.educavalieri.MicroserviceTests.repositories.UserRepository;
import com.educavalieri.MicroserviceTests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public UserResponseDto insert(UserRequestDto dto) {
        User entity = userRepository.save(dto.toEntity());
        return User.toUseResponseDto(entity);
    }

    @Override
    @Transactional
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        return User.toListUseResponse(users);
    }

    @Transactional
    @Override
    public UserResponseDto findById(Long id) {

        Optional<User> entity = userRepository.findById(id);
        return User.toUseResponseDto(entity.get());
    }

    @Override
    public void delete(Long id) {
        UserResponseDto dto = findById(id);
        userRepository.delete(dto.toEntity());
    }

    @Override
    public UserResponseDto update(UserRequestDto dto) {
        User entity = userRepository.save(dto.toEntity());
        return User.toUseResponseDto(entity);
    }
}
