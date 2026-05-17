package com.mundocigarro.cigarroventa.externalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mundocigarro.cigarroventa.dto.ClienteDto;

@Service
public class ClienteService {

    @Autowired
    private RestTemplate restTemplate;

    public ClienteDto obternerCliente(Long idCliente){
        String url = "http://localhost:8081/api/v1/clientes/" + idCliente;
        return restTemplate.getForObject(url, ClienteDto.class);
    }

}
