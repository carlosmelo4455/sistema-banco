package com.carlos.banco.usecases.user;

import com.carlos.banco.repository.UserRepository;
import config.MapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private final UserRepository userRepository;
    private final ModelMapper mapper = new MapperConfig().modelMapper();
    @Autowired
    public DeleteUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.deleteById(userId);
    }

}
