package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.context.ContextContainer;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Car;
import com.Gleb.entities.Client;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clients/*")
public class ClientsController extends Controller {

    private ContextContainer<Client> contextContainer;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = getServletContext();
        this.contextContainer = new ContextContainer(
                (Service<Client>) servletContext.getAttribute("clientsService"),
                (RequestParser) servletContext.getAttribute("requestParser"),
                (Converter<Client>) servletContext.getAttribute("clientsConverter"),
                (Validator) servletContext.getAttribute("clientsValidator")
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
