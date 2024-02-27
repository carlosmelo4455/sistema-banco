package com.carlos.banco.controller;

import com.carlos.banco.DTO.user.RegisterUserDTO;
import com.carlos.banco.DTO.user.UpdateUserDTO;
import com.carlos.banco.usecases.user.DeleteUser;
import com.carlos.banco.usecases.user.RegisterUser;
import com.carlos.banco.usecases.user.UpdateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RegisterUser registerUser;

    private final UpdateUser updateUser;

    private final DeleteUser deleteUser;

//    private final LoginUser loginUser;


    public UserController(RegisterUser registerUser, UpdateUser updateUser, DeleteUser deleteUser) {
        this.registerUser = registerUser;
        this.updateUser = updateUser;
        this.deleteUser = deleteUser;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody RegisterUserDTO registerUserDTO){
        registerUser.execute(registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody UpdateUserDTO updateUserDTO, @PathVariable Long id){
        updateUser.execute(id,updateUserDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        deleteUser.execute(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
//    @PostMapping("/login")
//    public ResponseEntity<Void> loginUser(@RequestBody LoginDTO userDTO){
//        loginUser.execute(userDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }


}
