package com.mundocigarro.cigarroventa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mundocigarro.cigarroventa.model.Venta;
import com.mundocigarro.cigarroventa.service.VentaService;

@RestController
@RequestMapping("/api/v1/ventas")

public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> listar(){

        List<Venta> ventas = ventaService.mostrarVentas();

        if(ventas.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscar(@PathVariable Long id){

        Venta venta = ventaService.obtenerVentaPorId(id);

        if(venta == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Venta venta){

        Venta nuevaVenta = ventaService.crearVenta(venta);

        if(nuevaVenta == null){
            return ResponseEntity.badRequest()
                    .body("El cliente no existe");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> modificar(@PathVariable Long id,
                                           @RequestBody Venta venta){

        try {

            Venta ven = ventaService.obtenerVentaPorId(id);

            ven.setIdVenta(id);
            ven.setIdCliente(venta.getIdCliente());
            ven.setFechaVenta(venta.getFechaVenta());
            ven.setTotalVenta(venta.getTotalVenta());

            ventaService.crearVenta(ven);

            return ResponseEntity.ok(ven);

        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){

        try {

            ventaService.eliminarVenta(id);

            return ResponseEntity.ok(
                    "Venta eliminada correctamente");

        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }
}