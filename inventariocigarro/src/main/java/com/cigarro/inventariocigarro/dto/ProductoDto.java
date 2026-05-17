package com.cigarro.inventariocigarro.dto;

import lombok.Data;

@Data
public class ProductoDto {

    private Long idProducto;
    private String nombre;
    private String marca;
    private String tipo;
    private Float precio;

}
