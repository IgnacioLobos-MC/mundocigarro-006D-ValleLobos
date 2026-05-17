package com.mundocigarro.cigarroventa.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private Long idCliente;
    private String nombre;
    private String email;
    private String telefono;
}
