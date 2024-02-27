package com.carlos.banco.usecases.user;

import com.carlos.banco.DTO.user.UpdateUserDTO;
import com.carlos.banco.entities.User;
import com.carlos.banco.model.UserModel;
import com.carlos.banco.repository.UserRepository;
import config.MapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {

    private final UserRepository userRepository;
    private final ModelMapper mapper = new MapperConfig().modelMapper();

    @Autowired
    public UpdateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long usuarioID, UpdateUserDTO userDTO) {
        UserModel existingUserModel = userRepository.findById(usuarioID).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        User existingUser = mapper.map(existingUserModel, User.class);
        User editedUser = mapper.map(userDTO, User.class);
        mapper.map(editedUser, existingUser);
        UserModel userModelToSave = mapper.map(existingUser, UserModel.class);
        userRepository.save(userModelToSave);
    }
}