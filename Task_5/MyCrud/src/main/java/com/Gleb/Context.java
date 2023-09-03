package com.Gleb;

import com.Gleb.converters.CarsConverter;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Car;
import com.Gleb.entities.Client;
import com.Gleb.repositories.CarsRepository;
import com.Gleb.repositories.ClientsRepository;
import com.Gleb.repositories.Repository;
import com.Gleb.services.CarsService;
import com.Gleb.services.Service;
import com.Gleb.validators.CarsValidator;
import com.Gleb.validators.Validator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Context implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        ServletContext servletContext = contextEvent.getServletContext();

        RequestParser requestParser = new RequestParser();
        servletContext.setAttribute("requestParser", requestParser);

        Repository<Car> carsRepository =  new CarsRepository();
        Service<Car> carsService = new CarsService(carsRepository);
        Converter<Car> carsConverter = new CarsConverter();
        Validator carsValidator = new CarsValidator();
        servletContext.setAttribute("carsRepository", carsRepository);
        servletContext.setAttribute("carsService", carsService);
        servletContext.setAttribute("carsConverter", carsConverter);
        servletContext.setAttribute("carsValidator", carsValidator);

        Repository<Client> clientsRepository = new ClientsRepository();

    }

    public void contextDestroyed(ServletContextEvent contextEvent) {}
}
