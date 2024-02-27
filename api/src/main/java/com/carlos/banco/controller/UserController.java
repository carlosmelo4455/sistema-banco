package com.carlos.banco.controller;

import com.carlos.banco.DTO.user.RegisterUserDTO;
import com.carlos.banco.usecases.user.RegisterUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegisterUser registerUser;

    public UserController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody RegisterUserDTO userDTO){
        registerUser.execute(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
