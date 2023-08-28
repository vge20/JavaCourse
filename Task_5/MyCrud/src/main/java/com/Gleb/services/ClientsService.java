package com.Gleb.services;

import com.Gleb.entities.Client;
import com.Gleb.repositories.ClientsRepository;

public class ClientsService {

    private ClientsRepository clientsRepository;

    public ClientsService() {
        this.clientsRepository = new ClientsRepository();
    }

    public Client getClient(int id) {
        Client client;
        try {
            client = clientsRepository.getClientById(id);
        } catch (Exception e) {
            return null;
        }

        return client;
    }

    public boolean addClient(Client client) {
        try {
            clientsRepository.addClient(client);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean updateClient(Client client) {
        try {
            clientsRepository.updateClient(client);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public boolean deleteClient(int id) {
        try {
            clientsRepository.deleteClient(id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
