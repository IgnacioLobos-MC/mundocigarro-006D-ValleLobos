package com.mundocigarro.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundocigarro.delivery.dto.VentaDto;
import com.mundocigarro.delivery.externalservice.VentaService;
import com.mundocigarro.delivery.model.Delivery;
import com.mundocigarro.delivery.repository.DeliveryRepository;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private VentaService ventaService;


    public List<Delivery> listar() {
        return deliveryRepository.findAll();
    }


    public Delivery buscar(Long id) {
        return deliveryRepository.findById(id).get();
    }

    public Delivery guardar(Delivery delivery) {

        VentaDto venta =
                ventaService.obtenerVenta(delivery.getIdVenta());

        if (venta != null) {
            return deliveryRepository.save(delivery);
        }

        return null;
    }

  
    public void eliminar(Long id) {
        deliveryRepository.deleteById(id);
    }
}