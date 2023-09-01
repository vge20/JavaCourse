package com.Gleb.services;

import com.Gleb.entities.Client;
import com.Gleb.exceptions.WorkingWithDBException;
import com.Gleb.repositories.ClientsRepository;
import com.Gleb.repositories.Repository;

public class ClientsService implements Service {

    private Repository<Client> clientsRepository;

    public ClientsService() {
        this.clientsRepository = new ClientsRepository();
    }

    @Override
    public Object get(int id) throws WorkingWithDBException {
        try {
            return clientsRepository.getById(id);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void add(Object entity) throws WorkingWithDBException {
        try {
            clientsRepository.add((Client) entity);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void update(Object entity) throws WorkingWithDBException {
        try {
            clientsRepository.update((Client) entity);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }

    @Override
    public void delete(int id) throws WorkingWithDBException {
        try {
            clientsRepository.delete(id);
        }
        catch (Exception e) {
            throw new WorkingWithDBException();
        }
    }
}
