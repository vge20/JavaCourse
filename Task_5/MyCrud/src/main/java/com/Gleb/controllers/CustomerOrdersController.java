package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.converters.CustomerOrdersConverter;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.services.CustomerOrdersService;
import com.Gleb.services.Service;
import com.Gleb.validators.CustomerOrdersValidator;
import com.Gleb.validators.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer_orders")
public class CustomerOrdersController extends HttpServlet implements Controller {

    private Service<CustomerOrder> customerOrdersService;

    private RequestParser requestParser;

    private Converter<CustomerOrder> customerOrdersConverter;

    private Validator customerOrdersValidator;

    public CustomerOrdersController() {
        this.customerOrdersService = new CustomerOrdersService();
        this.requestParser = new RequestParser();
        this.customerOrdersConverter = new CustomerOrdersConverter();
        this.customerOrdersValidator = new CustomerOrdersValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.handleGet(req, resp, customerOrdersService, customerOrdersConverter,
                customerOrdersValidator, requestParser);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePost(req, resp, customerOrdersService, customerOrdersConverter,
                customerOrdersValidator, requestParser);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePut(req, resp, customerOrdersService, customerOrdersConverter,
                customerOrdersValidator, requestParser);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        this.handleDelete(req, resp, customerOrdersService, customerOrdersValidator, requestParser);
    }
}
