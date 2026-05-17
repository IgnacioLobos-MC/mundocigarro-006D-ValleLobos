package com.mundocigarro.detalleventa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mundocigarro.detalleventa.model.DetalleVenta;
import com.mundocigarro.detalleventa.service.DetalleVentaService;

@RestController
@RequestMapping("/api/v1/detalleventa")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> listar(){

        List<DetalleVenta> lista = detalleVentaService.listar();

        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> buscar(@PathVariable Long id){

        try{
            DetalleVenta detalle = detalleVentaService.buscar(id);
            return ResponseEntity.ok(detalle);

        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<DetalleVenta>> buscarPorVenta(@PathVariable Long idVenta){

        List<DetalleVenta> lista = detalleVentaService.buscarPorVenta(idVenta);

        if(lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> guardar(@RequestBody DetalleVenta detalleVenta){

        DetalleVenta nuevo = detalleVentaService.guardar(detalleVenta);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){

        detalleVentaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}