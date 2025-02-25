package com.medes.microservicio_usuario_v2.service;

import com.medes.microservicio_usuario_v2.domain.entity.User;
import com.medes.microservicio_usuario_v2.domain.repository.UserRepository;
import com.medes.microservicio_usuario_v2.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public String delete(Long idUser) {
        userRepository.deleteById(idUser);
        return "Id: " + idUser + " delete";
    }
}
