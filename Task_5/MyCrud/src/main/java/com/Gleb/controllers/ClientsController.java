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
public class ClientsController extends HttpServlet {

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

        Integer id = requestParser.getId(req);
        if (id == null) {
            resp.setStatus(400);
            return;
        }

        if (!clientsValidator.validateId(id)) {
            resp.setStatus(400);
            return;
        }

        Client client = clientsService.getClient(id);
        if (client == null) {
            resp.setStatus(500);
            return;
        }

        String jsonClient = clientsConverter.convertToJson(client);
        if (jsonClient == null) {
            resp.setStatus(500);
            return;
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            resp.setStatus(500);
            return;
        }
        out.print(jsonClient);
        out.flush();
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String reqBody = requestParser.getRequestBody(req);
        if (reqBody == null) {
            resp.setStatus(400);
            return;
        }

        Client client = clientsConverter.convertFromJson(reqBody);
        if (client == null) {
            resp.setStatus(400);
            return;
        }

        if (!clientsValidator.validateForAdd(client)) {
            resp.setStatus(400);
            return;
        }

        if (!clientsService.addClient(client)) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(201);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

        String reqBody = requestParser.getRequestBody(req);
        if (reqBody == null) {
            resp.setStatus(400);
            return;
        }

        Client client = clientsConverter.convertFromJson(reqBody);
        if (client == null) {
            resp.setStatus(400);
            return;
        }

        if (!clientsValidator.validateForUpdate(client)) {
            resp.setStatus(400);
            return;
        }

        if (!clientsService.updateClient(client)) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(204);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        Integer id = requestParser.getId(req);
        if (id == null) {
            resp.setStatus(400);
            return;
        }

        if (!clientsValidator.validateId(id)) {
            resp.setStatus(400);
            return;
        }

        if (!clientsService.deleteClient(id)) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(204);
    }
}
