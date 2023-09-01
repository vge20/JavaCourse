package com.Gleb.services;

import com.Gleb.entities.Client;
import com.Gleb.repositories.ClientsRepository;
import com.Gleb.repositories.Repository;

import java.sql.SQLException;

public class ClientsService implements Service {

    private Repository<Client> clientsRepository;

    public ClientsService() {
        this.clientsRepository = new ClientsRepository();
    }

    @Override
    public Object get(int id) throws Exception {
        return clientsRepository.getById(id);
    }

    @Override
    public void add(Object entity) throws SQLException {
        clientsRepository.add((Client) entity);
    }

    @Override
    public void update(Object entity) throws SQLException {
        clientsRepository.update((Client) entity);
    }

    @Override
    public void delete(int id) throws SQLException {
        clientsRepository.delete(id);
    }
}
