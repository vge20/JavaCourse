package com.Gleb.services;

import com.Gleb.entities.Client;
import com.Gleb.repositories.ClientsRepository;

import java.sql.SQLException;

public class ClientsService {

    private ClientsRepository clientsRepository;

    public ClientsService() {
        this.clientsRepository = new ClientsRepository();
    }

    public Client getClient(int id) throws Exception {
        return clientsRepository.getClientById(id);
    }

    public void addClient(Client client) throws SQLException {
        clientsRepository.addClient(client);
    }

    public void updateClient(Client client) throws SQLException {
        clientsRepository.updateClient(client);
    }

    public void deleteClient(int id) throws SQLException {
        clientsRepository.deleteClient(id);
    }
}
