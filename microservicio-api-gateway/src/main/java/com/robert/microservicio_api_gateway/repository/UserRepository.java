package com.robert.microservicio_api_gateway.repository;

import com.robert.microservicio_api_gateway.model.Role;
import com.robert.microservicio_api_gateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    
    //Este metodo es para actualizar un usuario dependiendo el rol
    @Modifying // @Modifying indica que ese metodo hara modificaciones
    @Query("update User set role=:role where username=:username") //Sentencia SQL que actualiza un usuario por un rol
    void updateUserRole(@Param("username") String username, @Param("role")Role role);


}
