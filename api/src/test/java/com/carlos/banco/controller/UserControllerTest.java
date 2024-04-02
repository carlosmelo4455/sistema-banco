package com.carlos.banco.controller;

import com.carlos.banco.DTO.user.RegisterUserDTO;
import com.carlos.banco.DTO.user.UpdateUserDTO;
import com.carlos.banco.usecases.user.DeleteUser;
import com.carlos.banco.usecases.user.RegisterUser;
import com.carlos.banco.usecases.user.UpdateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private RegisterUser registerUser;

    @Mock
    private UpdateUser updateUser;

    @Mock
    private DeleteUser deleteUser;

    @InjectMocks
    private UserController userController;

    private RegisterUserDTO registerUserDTO;
    private UpdateUserDTO updateUserDTO;

    @BeforeEach
    public void setup() {
        registerUserDTO = new RegisterUserDTO();
        updateUserDTO = new UpdateUserDTO();
    }

    @Test
    public void shouldCreateUser() {
        ResponseEntity<Void> response = userController.createUser(registerUserDTO);
        verify(registerUser, times(1)).execute(registerUserDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void shouldUpdateUser() {
        Long id = 1L;
        ResponseEntity<Void> response = userController.updateUser(updateUserDTO, id);
        verify(updateUser, times(1)).execute(id, updateUserDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldDeleteUser() {
        Long id = 1L;
        ResponseEntity<Void> response = userController.deleteUser(id);
        verify(deleteUser, times(1)).execute(id);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}