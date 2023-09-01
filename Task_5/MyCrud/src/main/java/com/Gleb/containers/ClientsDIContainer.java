package com.Gleb.containers;

import com.Gleb.RequestParser;
import com.Gleb.converters.ClientsConverter;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Client;
import com.Gleb.repositories.ClientsRepository;
import com.Gleb.repositories.Repository;
import com.Gleb.services.ClientsService;
import com.Gleb.services.Service;
import com.Gleb.validators.ClientsValidator;
import com.Gleb.validators.Validator;
import lombok.Getter;

@Getter
public class ClientsDIContainer {

    private Converter<Client> clientsConverter;

    private RequestParser requestParser;

    private Validator clientsValidator;

    private Service<Client> clientsService;

    private Repository<Client> clientsRepository;

    public ClientsDIContainer() {
        this.clientsConverter = new ClientsConverter();
        this.clientsRepository = new ClientsRepository();
        this.clientsService = new ClientsService(clientsRepository);
        this.clientsValidator = new ClientsValidator();
        this.requestParser = new RequestParser();
    }
}
