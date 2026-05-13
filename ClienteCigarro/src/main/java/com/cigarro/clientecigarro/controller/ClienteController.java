package com.cigarro.clientecigarro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cigarro.clientecigarro.model.Cliente;
import com.cigarro.clientecigarro.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")

public class ClienteController {

   @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = clienteService.mostrarCliente();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")//buscar por id
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscaClienteId(id);
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente unCliente) {
        Cliente clienteNuevo = clienteService.creaCliente(unCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> modificar(@PathVariable Long id, @RequestBody Cliente unCliente) {
        try {
            Cliente cli = clienteService.buscaClienteId(id);
            cli.setIdCliente(id);
            cli.setNombre(unCliente.getNombre());
            cli.setEmail(unCliente.getEmail());
            cli.setTelefono(unCliente.getTelefono());
            clienteService.creaCliente(cli);
            return ResponseEntity.ok(cli);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.eliminarCliente(id);
            return "El cliente ha sido eliminado satisfactoriamente";
        } catch (Exception e) {
            return "El cliente no existe";
        }
    }


}
