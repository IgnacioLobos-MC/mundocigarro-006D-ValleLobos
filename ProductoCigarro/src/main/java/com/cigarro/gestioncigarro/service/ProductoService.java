package com.cigarro.gestioncigarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cigarro.gestioncigarro.model.Producto;
import com.cigarro.gestioncigarro.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List <Producto> mostrarProducto(){
        return productoRepository.findAll();
    }

    public Producto buscaProductoId(Long id){
        return productoRepository.findById(id).get();
    }

    public Producto creaProducto(Producto unProducto){
        return productoRepository.save(unProducto);
    }

    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }

}
