package com.cigarro.clientecigarro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cigarro.clientecigarro.model.Cliente;
import com.cigarro.clientecigarro.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> mostrarCliente() {
        return clienteRepository.findAll();
    }

    public Cliente buscaClienteId(Long id) {
        return clienteRepository.findById(id).get();
    }

    public Cliente creaCliente(Cliente unCliente) {
        return clienteRepository.save(unCliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
