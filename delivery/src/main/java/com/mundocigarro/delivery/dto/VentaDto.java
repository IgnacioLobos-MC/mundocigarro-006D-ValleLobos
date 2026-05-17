package com.mundocigarro.delivery.dto;

import java.time.LocalDate;

public class VentaDto {

    private Long idVenta;
    private Long idCliente;
    private LocalDate fechaVenta;
    private Double totalVenta;

    public VentaDto() {
    }

    public VentaDto(Long idVenta, Long idCliente,
                    LocalDate fechaVenta, Double totalVenta) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }
}