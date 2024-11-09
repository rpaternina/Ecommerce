package com.robert.microservice_inmueble.service;

import com.robert.microservice_inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {
    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long idInmueble);

    List<Inmueble> findAllInmuebles();
}
