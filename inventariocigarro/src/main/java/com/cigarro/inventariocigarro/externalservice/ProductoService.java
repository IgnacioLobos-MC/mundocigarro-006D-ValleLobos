package com.cigarro.inventariocigarro.externalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cigarro.inventariocigarro.dto.ProductoDto;

@Service
public class ProductoService {

    @Autowired
    private RestTemplate restTemplate;

    public ProductoDto obtenerProducto(Long id){

        String url = "http://localhost:8082/api/v1/productos/" + id;

        return restTemplate.getForObject(url, ProductoDto.class);
    }
}
