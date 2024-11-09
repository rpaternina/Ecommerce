package com.robert.microservicio_compea.service;

import com.robert.microservicio_compea.model.Compra;

import java.util.List;

public interface CompraService {

    Compra saveCompra(Compra compra);

    List<Compra> findByCompraOfUser(Long userId);
}
