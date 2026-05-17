package com.mundocigarro.pagocigarro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pago")

public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @Column(nullable = false)
    private Long idVenta;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private String estadoPago;

    @Column(nullable = false)
    private LocalDate fechaPago;


}
