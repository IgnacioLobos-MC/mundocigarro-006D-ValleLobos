package com.mundocigarro.detalleventa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mundocigarro.detalleventa.model.DetalleVenta;

public interface DetalleVentaRepository  extends JpaRepository<DetalleVenta, Long> {

    List<DetalleVenta> findByIdVenta(Long idVenta);

}
