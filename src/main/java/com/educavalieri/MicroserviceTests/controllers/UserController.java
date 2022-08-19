package com.educavalieri.MicroserviceTests.controllers;

import com.educavalieri.MicroserviceTests.dtos.UserRequestDto;
import com.educavalieri.MicroserviceTests.dtos.UserResponseDto;
import com.educavalieri.MicroserviceTests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> dtos = userService.findAll();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/findById{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Long id){
        UserResponseDto dto = userService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<UserResponseDto> insert(@RequestBody UserRequestDto dto){
        UserResponseDto dtoResponse = userService.insert(dto);
        return ResponseEntity.ok().body(dtoResponse);
    }

    @DeleteMapping(value = "/delete{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
