package com.educavalieri.MicroserviceTests.entities;

import com.educavalieri.MicroserviceTests.dtos.UserRequestDto;
import com.educavalieri.MicroserviceTests.dtos.UserResponseDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String name;
    private String password;
    private String email;

    public static UserResponseDto toUseResponseDto(User entity){

        UserResponseDto dto = UserResponseDto
                .builder()
                .user_id(entity.getUser_id())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
        return dto;
    }

    public static UserRequestDto toUseRequestDto(User entity){

        UserRequestDto dto = UserRequestDto
                .builder()
                .user_id(entity.getUser_id())
                .password(entity.getPassword())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
        return dto;
    }

    public static List<UserResponseDto> toListUseResponse(List<User> users){
        List<UserResponseDto> userResponseDtos = new ArrayList<>();

        for ( User list : users) {
            UserResponseDto dto =  new UserResponseDto();
            dto.setUser_id(list.getUser_id());
            dto.setName(list.getName());
            dto.setEmail(list.getEmail());
            userResponseDtos.add(dto);
        }

        return userResponseDtos;
    }

    public static List<UserRequestDto> toListUseRequest(List<User> users){
        List<UserRequestDto> userRequestDtos = new ArrayList<>();

        for ( User list : users) {
            UserRequestDto dto =  new UserRequestDto();
            dto.setUser_id(list.getUser_id());
            dto.setName(list.getName());
            dto.setEmail(list.getEmail());
            userRequestDtos.add(dto);
        }

        return userRequestDtos;
    }

}