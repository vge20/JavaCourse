package com.Gleb.containers;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.converters.CustomerOrdersConverter;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CustomerOrdersRepository;
import com.Gleb.repositories.Repository;
import com.Gleb.services.CustomerOrdersService;
import com.Gleb.services.Service;
import com.Gleb.validators.CustomerOrdersValidator;
import com.Gleb.validators.Validator;
import lombok.Getter;

@Getter
public class CustomerOrdersDIContainer {

    private Service<CustomerOrder> customerOrdersService;

    private RequestParser requestParser;

    private Converter<CustomerOrder> customerOrdersConverter;

    private Validator customerOrdersValidator;

    private Repository<CustomerOrder> customerOrdersRepository;

    public CustomerOrdersDIContainer() {
        this.customerOrdersConverter = new CustomerOrdersConverter();
        this.customerOrdersRepository = new CustomerOrdersRepository();
        this.customerOrdersService = new CustomerOrdersService(customerOrdersRepository);
        this.customerOrdersValidator = new CustomerOrdersValidator();
        this.requestParser = new RequestParser();
    }
}
