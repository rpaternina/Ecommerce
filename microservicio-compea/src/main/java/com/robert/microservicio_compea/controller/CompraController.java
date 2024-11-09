package com.robert.microservicio_compea.controller;


import com.robert.microservicio_compea.model.Compra;
import com.robert.microservicio_compea.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CompraService compraService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra){
        return new ResponseEntity<>(compraService.saveCompra(compra), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllCompraOfUserId(@PathVariable Long userId){
        // return ResponseEntity.ok(compraService.findByCompraOfUser(userId)); Otra forma de hacerlo
        return new ResponseEntity<>(compraService.findByCompraOfUser(userId), HttpStatus.OK);
    }
}
