package com.crud.service;

import com.crud.model.Cliente;

import java.util.List;

public interface ClienteService {
    public abstract Cliente createCliente(Cliente cliente);
    public abstract void updateCliente(Cliente cliente);
    public abstract Cliente getCliente (int id);
    public abstract List<Cliente> getClientes();
    public abstract void deleteCliente(int id);
    public abstract boolean isClienteExist(int id);
}
