package com.Gleb.services;

import com.Gleb.entities.Client;
import com.Gleb.repositories.ClientsRepository;
import com.Gleb.repositories.Repository;

import java.sql.SQLException;

public class ClientsService {

    private Repository<Client> clientsRepository;

    public ClientsService() {
        this.clientsRepository = new ClientsRepository();
    }

    public Client getClient(int id) throws Exception {
        return clientsRepository.getById(id);
    }

    public void addClient(Client client) throws SQLException {
        clientsRepository.add(client);
    }

    public void updateClient(Client client) throws SQLException {
        clientsRepository.update(client);
    }

    public void deleteClient(int id) throws SQLException {
        clientsRepository.delete(id);
    }
}
