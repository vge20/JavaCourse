package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.ClientsConverter;
import com.Gleb.converters.Converter;
import com.Gleb.entities.Client;
import com.Gleb.services.ClientsService;
import com.Gleb.validators.ClientsValidator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/clients")
public class ClientsController extends HttpServlet implements Controller {

    private Converter<Client> clientsConverter;

    private RequestParser requestParser;

    private ClientsValidator clientsValidator;

    private ClientsService clientsService;

    public ClientsController() {
        this.clientsConverter = new ClientsConverter();
        this.requestParser = new RequestParser();
        this.clientsValidator = new ClientsValidator();
        this.clientsService = new ClientsService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.handleGet(req, resp, clientsService, clientsConverter, clientsValidator, requestParser);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePost(req, resp, clientsService, clientsConverter, clientsValidator, requestParser);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        this.handlePut(req, resp, clientsService, clientsConverter, clientsValidator, requestParser);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        this.handleDelete(req, resp, clientsService, clientsValidator, requestParser);
    }
}
