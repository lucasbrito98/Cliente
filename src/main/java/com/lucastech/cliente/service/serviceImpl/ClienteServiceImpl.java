package com.lucastech.cliente.service.serviceImpl;

import com.lucastech.cliente.converter.ClienteConverter;
import com.lucastech.cliente.dto.request.ClienteNovoRequestDto;
import com.lucastech.cliente.dto.response.ClienteResponseDto;
import com.lucastech.cliente.entities.Cliente;
import com.lucastech.cliente.repository.ClienteRepository;
import com.lucastech.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponseDto criar(ClienteNovoRequestDto clienteNovoRequestDto) {

        Cliente cliente = ClienteConverter.toCliente(clienteNovoRequestDto);
        clienteRepository.save(cliente);
        return ClienteConverter.toClienteReponseDto(cliente);

    }


    @Override
    public Page<Cliente> consultar(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    public Cliente consultarPorUuid(UUID uuid) {
        return clienteRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado por uuid: " + uuid));
    }

    @Override
    public Cliente consultarPorCpf(String cpf) {
        return clienteRepository.buscaClientePorDocumento(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo cpf: " + cpf));
    }

    @Override
    public Cliente consultarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado por email: " + email));
    }

    @Override
    @Transactional
    public void excluirPorCpf(String cpf) {
        clienteRepository.deleteByCpf(cpf);

    }

    @Override
    @Transactional
    public void excluirPorUuid(UUID uuid) {
        clienteRepository.deleteById(uuid);
    }

}

