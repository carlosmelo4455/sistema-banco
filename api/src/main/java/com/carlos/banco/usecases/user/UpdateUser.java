package com.carlos.banco.usecases.user;

import com.carlos.banco.DTO.UserDTO;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    @Autowired
    private UserRepository userRepository;


    public UserDTO execute(Long usuarioID, UserDTO userDTO) {
        UserModel userModel = userRepository.findById(usuarioID).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (userDTO.name() != null) userModel.setName(userDTO.name());
        if (userDTO.phone() != null) userModel.setPhone(userDTO.phone());
        if (userDTO.password() != null) userModel.setPassword(userDTO.password());
        userRepository.save(userModel);
        return userModel.toDTO();
    }
}