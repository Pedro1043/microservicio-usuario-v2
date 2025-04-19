package com.medes.microservicio_usuario_v2.domain.repository;

import com.medes.microservicio_usuario_v2.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getByUsernameAndPassword(String username, String password);

}