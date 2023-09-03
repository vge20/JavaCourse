package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.context.ContextContainer;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Car;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarsController extends Controller {

    private ContextContainer<Car> contextContainer;

    public CarsController() {
        ServletContext servletContext = getServletContext();
        this.contextContainer = new ContextContainer(
                (Service<Car>) servletContext.getAttribute("carsService"),
                (RequestParser) servletContext.getAttribute("requestParser"),
                (Converter<Car>) servletContext.getAttribute("carsConverter"),
                (Validator) servletContext.getAttribute("carsValidator")
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.handleGet(req, resp, this.contextContainer);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePost(req, resp, this.contextContainer);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePut(req, resp, this.contextContainer);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        this.handleDelete(req, resp, this.contextContainer);
    }
}
