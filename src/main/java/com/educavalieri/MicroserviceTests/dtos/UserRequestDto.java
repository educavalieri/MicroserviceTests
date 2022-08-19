package com.educavalieri.MicroserviceTests.dtos;

import com.educavalieri.MicroserviceTests.entities.User;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    private Long user_id;
    private String name;
    private String password;
    private String email;

    public User toEntity(){
        User entity = User
                .builder()
                .user_id(user_id)
                .name(name)
                .password(password)
                .email(email)
                .build();

        return entity;
    }

}
