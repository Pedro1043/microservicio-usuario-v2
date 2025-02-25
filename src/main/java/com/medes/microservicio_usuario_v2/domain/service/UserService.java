package com.medes.microservicio_usuario_v2.domain.service;

import com.medes.microservicio_usuario_v2.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    Optional<User> getById(Long idUser);

    Optional<User> getByUsername(String username);

    User save(User user);

    String delete(Long idUser);
}
