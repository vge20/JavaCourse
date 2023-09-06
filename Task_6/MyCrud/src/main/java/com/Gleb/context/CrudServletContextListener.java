package com.Gleb.context;

import com.Gleb.RequestParser;
import com.Gleb.converters.CarsConverter;
import com.Gleb.converters.ClientsConverter;
import com.Gleb.converters.Converter;
import com.Gleb.converters.CustomerOrdersConverter;
import com.Gleb.entities.Car;
import com.Gleb.entities.Client;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CarsRepository;
import com.Gleb.repositories.ClientsRepository;
import com.Gleb.repositories.CustomerOrdersRepository;
import com.Gleb.repositories.Repository;
import com.Gleb.services.CarsService;
import com.Gleb.services.ClientsService;
import com.Gleb.services.CustomerOrdersService;
import com.Gleb.services.Service;
import com.Gleb.validators.CarsValidator;
import com.Gleb.validators.ClientsValidator;
import com.Gleb.validators.CustomerOrdersValidator;
import com.Gleb.validators.Validator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CrudServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        ServletContext servletContext = contextEvent.getServletContext();

        RequestParser requestParser = new RequestParser();
        servletContext.setAttribute("requestParser", requestParser);

        Repository<Car> carsRepository =  new CarsRepository();
        Service<Car> carsService = new CarsService(carsRepository);
        Converter<Car> carsConverter = new CarsConverter();
        Validator carsValidator = new CarsValidator();
        servletContext.setAttribute("carsService", carsService);
        servletContext.setAttribute("carsConverter", carsConverter);
        servletContext.setAttribute("carsValidator", carsValidator);

        Repository<Client> clientsRepository = new ClientsRepository();
        Service<Client> clientsService = new ClientsService(clientsRepository);
        Converter<Client> clientsConverter = new ClientsConverter();
        Validator clientsValidator = new ClientsValidator();
        servletContext.setAttribute("clientsService", clientsService);
        servletContext.setAttribute("clientsConverter", clientsConverter);
        servletContext.setAttribute("clientsValidator", clientsValidator);

        Repository<CustomerOrder> customerOrdersRepository = new CustomerOrdersRepository();
        Service<CustomerOrder> customerOrdersService = new CustomerOrdersService(customerOrdersRepository,
                clientsRepository, carsRepository);
        Converter<CustomerOrder> customerOrdersConverter = new CustomerOrdersConverter();
        Validator customerOrdersValidator = new CustomerOrdersValidator();
        servletContext.setAttribute("customerOrdersService", customerOrdersService);
        servletContext.setAttribute("customerOrdersConverter", customerOrdersConverter);
        servletContext.setAttribute("customerOrdersValidator", customerOrdersValidator);
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {}
}
