package com.lucastech.cliente.converter;

import com.lucastech.cliente.dto.request.ClienteNovoRequestDto;
import com.lucastech.cliente.dto.response.ClienteResponseDto;
import com.lucastech.cliente.entities.Cliente;

public class ClienteConverter {

    public static Cliente toCliente(ClienteNovoRequestDto clienteNovoRequestDto) {

        return Cliente.builder()
                .nome(clienteNovoRequestDto.getNome())
                .cpf(clienteNovoRequestDto.getCpf())
                .email(clienteNovoRequestDto.getEmail())
                .telefone(clienteNovoRequestDto.getTelefone())
                .endereco(clienteNovoRequestDto.getEndereco())
                .build();

    }

    public static ClienteResponseDto toClienteReponseDto (Cliente cliente){


       return ClienteResponseDto.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .endereco(cliente.getEndereco())
                .telefone(cliente.getTelefone())
                .build();



    }


}
