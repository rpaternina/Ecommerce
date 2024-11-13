package com.robert.microservicio_api_gateway.service;

import com.robert.microservicio_api_gateway.model.Role;
import com.robert.microservicio_api_gateway.model.User;
import com.robert.microservicio_api_gateway.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        // Encriptamos la contraseña del usuario antes de pasarla a la bd
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Indicamos el rol
        user.setRole(Role.USER);
        user.setFechaCreacion(LocalDateTime.now());
        return userRepository.save(user);

    }


    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    /**
     * Metodo para actualizar el rol de un usuario
     * @Transactional es porque en el metodo creado en la interfaz estamos usando SQL
     * @param newRole
     * @param username
     */
    @Transactional
    @Override
    public void changeRole(Role newRole, String username){
        userRepository.updateUserRole(username,newRole);
    }
}
