package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.context.ContextContainer;
import com.Gleb.converters.Converter;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer_orders")
public class CustomerOrdersController extends Controller {

    private ContextContainer<CustomerOrder> contextContainer;

    public CustomerOrdersController() {
        ServletContext servletContext = getServletContext();
        this.contextContainer = new ContextContainer(
                (Service<CustomerOrder>) servletContext.getAttribute("customerOrdersService"),
                (RequestParser) servletContext.getAttribute("requestParser"),
                (Converter<CustomerOrder>) servletContext.getAttribute("customerOrdersConverter"),
                (Validator) servletContext.getAttribute("customerOrdersValidator")
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.handleGet(req, resp, contextContainer);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePost(req, resp, contextContainer);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePut(req, resp, contextContainer);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        this.handleDelete(req, resp, contextContainer);
    }
}
