package com.mundocigarro.detalleventa.externalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mundocigarro.detalleventa.dto.VentaDto;

@Service
public class VentaService {

    @Autowired
    private RestTemplate restTemplate;

    public VentaDto obtenerVenta(Long idVenta){

        String url = "http://localhost:8083/api/v1/ventas/" + idVenta;

        return restTemplate.getForObject(url, VentaDto.class);
    }
}