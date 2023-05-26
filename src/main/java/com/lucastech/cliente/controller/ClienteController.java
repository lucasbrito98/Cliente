package com.lucastech.cliente.controller;


import com.lucastech.cliente.dto.request.ClienteNovoRequestDto;
import com.lucastech.cliente.dto.response.ClienteResponseDto;
import com.lucastech.cliente.entities.Cliente;
import com.lucastech.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDto criar (@RequestBody ClienteNovoRequestDto clienteNovoRequestDto){
        //ClienteResponseDto clienteResponseDto = clienteService.criar(clienteNovoRequestDto);
        return clienteService.criar(clienteNovoRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Cliente> consultar(Pageable pageable){
        return clienteService.consultar(pageable);
    }

    @GetMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente consultarPorUuid(@PathVariable("uuid") UUID uuid){
        return clienteService.consultarPorUuid(uuid);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente consultarPorCpf(@PathVariable("cpf") String cpf){
        return clienteService.consultarPorCpf(cpf);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente consultarPorEmail(@PathVariable("email") String email){
        return clienteService.consultarPorEmail(email);
    }

    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorCpf(@PathVariable("cpf") String cpf){
        clienteService.excluirPorCpf(cpf);
    }

    @DeleteMapping("/uuid/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public  void excluirPorUuid (@PathVariable("uuid") UUID uuid){
            clienteService.excluirPorUuid(uuid);
    }

}
