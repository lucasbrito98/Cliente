package com.lucastech.cliente.controller;

import com.lucastech.cliente.entities.Cliente;
import com.lucastech.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/clientes")
public class ClienteController {
    private final ClienteService clienteService;

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public Cliente criar (@RequestBody Cliente clienteNovo){
        return clienteService.criar(clienteNovo);
    }
}
