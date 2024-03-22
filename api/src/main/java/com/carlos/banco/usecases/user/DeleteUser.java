package com.carlos.banco.usecases.user;

import com.carlos.banco.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private final UserRepository userRepository;
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
