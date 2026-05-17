package com.cigarro.inventariocigarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cigarro.inventariocigarro.model.Inventario;
import com.cigarro.inventariocigarro.repository.InventarioRepository;

@Service
public class InventarioService {

     @Autowired
    private InventarioRepository inventarioRepository;

   
    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    
    public List<Inventario> listar() {
        return inventarioRepository.findAll();
    }

    
    public Inventario actualizar(Long id, Inventario inventario) {

        Inventario existente = inventarioRepository.findById(id).orElse(null);

        if (existente != null) {

            existente.setProducto(inventario.getProducto());
            existente.setMarca(inventario.getMarca());
            existente.setStock(inventario.getStock());
            existente.setPrecio(inventario.getPrecio());

            return inventarioRepository.save(existente);
        }

        return null;
    }

    
    public void eliminar(Long id) {
        inventarioRepository.deleteById(id);
    }

}
