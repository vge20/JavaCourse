package com.Gleb.services;

import com.Gleb.entities.Client;
import com.Gleb.repositories.Repository;
import lombok.AllArgsConstructor;

import java.sql.SQLException;

@AllArgsConstructor
public class ClientsService implements Service {

    private Repository<Client> clientsRepository;

    @Override
    public Object executeGet(int id) throws SQLException {
        return this.clientsRepository.getById(id);
    }

    @Override
    public void executeAdd(Object entity) throws SQLException {
        this.clientsRepository.add((Client) entity);
    }

    @Override
    public void executeUpdate(Object entity) throws SQLException {
        Client client = (Client) entity;
        if (this.clientsRepository.getById(client.getId()) == null) {
            this.clientsRepository.add(client);
        }
        else {
            this.clientsRepository.update(client);
        }
    }

    @Override
    public void executeDelete(int id) throws SQLException {
        this.clientsRepository.delete(id);
    }
}
