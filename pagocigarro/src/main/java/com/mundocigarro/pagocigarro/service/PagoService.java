package com.mundocigarro.pagocigarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundocigarro.pagocigarro.dto.VentaDto;
import com.mundocigarro.pagocigarro.externalservice.VentaService;
import com.mundocigarro.pagocigarro.model.Pago;
import com.mundocigarro.pagocigarro.repository.PagoRepository;

@Service

public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private VentaService ventaService;

    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    public Pago buscar(Long id) {
        return pagoRepository.findById(id).get();
    }

    public Pago guardar(Pago pago) {

        try {

        VentaDto venta =
                ventaService.obtenerVenta(pago.getIdVenta());

        if (venta != null) {
            return pagoRepository.save(pago);
        }

    } catch (Exception e) {

        System.out.println("Microservicio venta no disponible");

    }

    return null;
    }

    public Pago actualizar(Long id, Pago pago) {

        Pago pagoExistente =
                pagoRepository.findById(id).orElse(null);

        if (pagoExistente != null) {

            pagoExistente.setMetodoPago(
                    pago.getMetodoPago());

            pagoExistente.setMonto(
                    pago.getMonto());

            pagoExistente.setEstadoPago(
                    pago.getEstadoPago());

            pagoExistente.setFechaPago(
                    pago.getFechaPago());

            return pagoRepository.save(pagoExistente);
        }

        return null;
    }

    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }

}
