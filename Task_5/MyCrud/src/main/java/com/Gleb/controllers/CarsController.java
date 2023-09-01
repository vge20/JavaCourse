package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.containers.CarsDIContainer;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Car;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarsController extends HttpServlet implements Controller {

    private Service<Car> carsService;

    private RequestParser requestParser;

    private Converter<Car> carsConverter;

    private Validator carsValidator;

    public CarsController() {
        CarsDIContainer carsDIContainer = new CarsDIContainer();
        this.carsService = carsDIContainer.getCarsService();
        this.requestParser = carsDIContainer.getRequestParser();
        this.carsValidator = carsDIContainer.getCarsValidator();
        this.carsConverter = carsDIContainer.getCarsConverter();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.handleGet(req, resp, carsService, carsConverter, carsValidator, requestParser);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePost(req, resp, carsService, carsConverter, carsValidator, requestParser);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePut(req, resp, carsService, carsConverter, carsValidator, requestParser);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        this.handleDelete(req, resp, carsService, carsValidator, requestParser);
    }
}
