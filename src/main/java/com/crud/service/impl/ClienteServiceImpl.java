package com.crud.service.impl;
import com.crud.model.Cliente;
import com.crud.repository.ClienteRepository;
import com.crud.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Cliente createCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    @Override
    public void updateCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }
    @Override
    public Cliente getCliente( int id){
        Optional<Cliente> optional = clienteRepository.findById(id);
        Cliente cliente = optional.get();
        return cliente;
    }
    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteRepository.findAll();
    }
    @Override
    public void deleteCliente(int id){
        clienteRepository.deleteById(id);
    }
    @Override
    public boolean isClienteExist (int id){
        return clienteRepository.existsById(id);
    }
}
