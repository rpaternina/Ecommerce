package com.robert.microservicio_compea.repository;

import com.robert.microservicio_compea.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    // Buscamos una compra de un usuario por id del usuario
    List<Compra> findByUserId(Long userId);

}
