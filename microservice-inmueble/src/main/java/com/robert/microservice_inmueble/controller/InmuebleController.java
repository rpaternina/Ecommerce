package com.robert.microservice_inmueble.controller;


import com.robert.microservice_inmueble.model.Inmueble;
import com.robert.microservice_inmueble.service.InmuebleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inmueble")
@RequiredArgsConstructor
public class InmuebleController {

    private final InmuebleService inmuebleService;

    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody Inmueble inmueble){
        return new ResponseEntity<>(inmuebleService.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("{idInmueble}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long idInmueble){
        inmuebleService.deleteInmueble(idInmueble);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllInmuebles(){
        return new ResponseEntity<>(inmuebleService.findAllInmuebles(),HttpStatus.OK);
    }
}
