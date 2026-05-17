package com.cigarro.inventariocigarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cigarro.inventariocigarro.model.Inventario;
import com.cigarro.inventariocigarro.service.InventarioService;

@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {

        return inventarioService.guardar(inventario);
    }

    @GetMapping
    public List<Inventario> listar() {

        return inventarioService.listar();
    }

    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id,
                                 @RequestBody Inventario inventario) {

        return inventarioService.actualizar(id, inventario);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {

        inventarioService.eliminar(id);

        return "Producto eliminado correctamente";
    }


}
