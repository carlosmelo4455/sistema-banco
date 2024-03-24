package com.carlos.banco.usecases.user;

import com.carlos.banco.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteUser {

    private final UserRepository userRepository;

    public void execute(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.deleteById(userId);
    }

}
