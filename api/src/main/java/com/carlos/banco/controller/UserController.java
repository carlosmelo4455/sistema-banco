package com.carlos.banco.controller;

import com.carlos.banco.DTO.UserDTO;
import com.carlos.banco.usecases.user.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CreateUser createUser;


    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO){
        createUser.execute(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
