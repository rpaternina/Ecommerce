package com.robert.microservice_inmueble.service;

import com.robert.microservice_inmueble.model.Inmueble;
import com.robert.microservice_inmueble.repository.InmuebleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InmuebleServiceImpl implements InmuebleService{

    private final InmuebleRepository inmuebleRepository;


    @Override
    public Inmueble saveInmueble(Inmueble inmueble){
        inmueble.setFechaCreacion(LocalDateTime.now());
        return inmuebleRepository.save(inmueble);
    }

    @Override
    public void deleteInmueble(Long idInmueble){
        inmuebleRepository.deleteById(idInmueble);
    }

    @Override
    public List<Inmueble> findAllInmuebles(){
        return inmuebleRepository.findAll();
    }


}
