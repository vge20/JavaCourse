package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.containers.CustomerOrdersDIContainer;
import com.Gleb.converters.Converter;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.services.Service;
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
        CustomerOrdersDIContainer customerOrdersDIContainer = new CustomerOrdersDIContainer();
        this.customerOrdersService = customerOrdersDIContainer.getCustomerOrdersService();
        this.requestParser = customerOrdersDIContainer.getRequestParser();
        this.customerOrdersConverter = customerOrdersDIContainer.getCustomerOrdersConverter();
        this.customerOrdersValidator = customerOrdersDIContainer.getCustomerOrdersValidator();
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
