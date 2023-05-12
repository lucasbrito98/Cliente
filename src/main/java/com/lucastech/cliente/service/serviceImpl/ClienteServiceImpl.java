package com.lucastech.cliente.service.serviceImpl;

import com.lucastech.cliente.entities.Cliente;
import com.lucastech.cliente.repository.ClienteRepository;
import com.lucastech.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;
    @Override
    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}