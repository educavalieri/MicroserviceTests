package com.educavalieri.MicroserviceTests.dtos;

import com.educavalieri.MicroserviceTests.entities.User;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long user_id;
    private String name;
    private String email;

    public User toEntity(){
        User entity = User
                .builder()
                .user_id(user_id)
                .name(name)
                .email(email)
                .build();

        return entity;
    }
}
