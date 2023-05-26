package com.lucastech.cliente.service;
import com.lucastech.cliente.dto.request.ClienteNovoRequestDto;
import com.lucastech.cliente.dto.response.ClienteResponseDto;
import com.lucastech.cliente.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ClienteService {


    ClienteResponseDto criar(ClienteNovoRequestDto clienteNovoRequestDto);

    Page<Cliente> consultar(Pageable pageable);

    Cliente consultarPorUuid(UUID uuid);

    Cliente consultarPorCpf(String cpf);

    Cliente consultarPorEmail(String email);

    void excluirPorCpf(String cpf);

    void excluirPorUuid(UUID uuid);
}
