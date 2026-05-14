package com.mundocigarro.detalleventa.externalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mundocigarro.detalleventa.dto.ProductoDto;

@Service
public class ProductoService {

    @Autowired
    private RestTemplate restTemplate;

    public ProductoDto obtenerProducto(Long idProducto){

        String url = "http://localhost:8082/api/v1/productos/" + idProducto;

        return restTemplate.getForObject(url, ProductoDto.class);
    }
}