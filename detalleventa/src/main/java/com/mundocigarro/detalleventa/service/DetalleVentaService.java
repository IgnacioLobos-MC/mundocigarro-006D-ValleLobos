package com.mundocigarro.detalleventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mundocigarro.detalleventa.dto.ProductoDto;
import com.mundocigarro.detalleventa.dto.VentaDto;
import com.mundocigarro.detalleventa.externalservice.ProductoService;
import com.mundocigarro.detalleventa.externalservice.VentaService;
import com.mundocigarro.detalleventa.model.DetalleVenta;
import com.mundocigarro.detalleventa.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private VentaService ventaService;

    // LISTAR TODOS
    public List<DetalleVenta> listar() {
        return detalleVentaRepository.findAll();
    }

    // BUSCAR POR ID
    public DetalleVenta buscar(Long id) {
        return detalleVentaRepository.findById(id).get();
    }

    // BUSCAR DETALLES POR ID DE VENTA
    public List<DetalleVenta> buscarPorVenta(Long idVenta) {
        return detalleVentaRepository.findByIdVenta(idVenta);
    }

    // GUARDAR DETALLE VENTA
    public DetalleVenta guardar(DetalleVenta detalleVenta) {

        ProductoDto producto =
                productoService.obtenerProducto(detalleVenta.getIdProducto());

        VentaDto venta =
                ventaService.obtenerVenta(detalleVenta.getIdVenta());

        if (producto != null && venta != null) {

            detalleVenta.setSubtotal(
                    producto.getPrecio() * detalleVenta.getCantidad()
            );

            return detalleVentaRepository.save(detalleVenta);
        }

        return null;
    }

    // ELIMINAR
    public void eliminar(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
