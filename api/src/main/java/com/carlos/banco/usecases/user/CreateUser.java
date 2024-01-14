package com.carlos.banco.usecases.user;

import com.carlos.banco.DTO.UserDTO;
import com.carlos.banco.entities.User;
import com.carlos.banco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    @Autowired
    private UserRepository userRepository;

    public void create(UserDTO userDTO) {
        if (userRepository.findByCpf(userDTO.cpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }else {
            User user = userDTO.toEntity();
            userRepository.save(user.toModel());
        }
    }
}
