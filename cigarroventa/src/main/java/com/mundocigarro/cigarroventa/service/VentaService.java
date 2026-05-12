package com.mundocigarro.cigarroventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundocigarro.cigarroventa.dto.ClienteDto;
import com.mundocigarro.cigarroventa.externalservice.ClienteService;
import com.mundocigarro.cigarroventa.model.Venta;
import com.mundocigarro.cigarroventa.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteService clienteService;

    public List<Venta> mostrarVentas(){
        return ventaRepository.findAll();
    }

    public Venta crearVenta(Venta venta){

        ClienteDto cliente = clienteService.obternerCliente(venta.getIdCliente());

        if(cliente == null){
            return null;
        }
        return ventaRepository.save(venta);
    }

    public Venta obtenerVentaPorId(Long id){
        return ventaRepository.findById(id).orElse(null);
    }

    public void eliminarVenta(Long id){
        ventaRepository.deleteById(id);
    }
}
