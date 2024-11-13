package com.robert.microservicio_api_gateway.service;

import com.robert.microservicio_api_gateway.model.Role;
import com.robert.microservicio_api_gateway.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
