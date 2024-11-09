package com.robert.microservicio_compea.service;

import com.robert.microservicio_compea.model.Compra;
import com.robert.microservicio_compea.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService{

    private final CompraRepository compraRepository;


    /**
     * Guardar compra
     * @param compra
     * @return
     */
    @Override
    public Compra saveCompra(Compra compra){
        compra.setFechaCompra(LocalDateTime.now());
        return compraRepository.save(compra);
    }

    /**
     * Devuelve una lista de las compras de cierto usuario
     * @param userId
     * @return
     */
    @Override
    public List<Compra> findByCompraOfUser(Long userId){
        return compraRepository.findByUserId(userId);
    }


}
