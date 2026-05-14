package com.mundocigarro.delivery.model;

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

@Entity
@Table(name = "delivery")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDelivery;

    @Column(nullable = false)
    private Long idVenta;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String comuna;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private LocalDate fechaEnvio;

    @Column(nullable = false)
    private LocalDate fechaEntrega;
}

