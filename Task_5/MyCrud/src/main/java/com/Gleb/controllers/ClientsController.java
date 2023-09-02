package com.Gleb.controllers;

import com.Gleb.containers.ClientsDIContainer;
import com.Gleb.containers.ContextContainer;
import com.Gleb.entities.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clients")
public class ClientsController extends Controller {

    private ContextContainer<Car> contextContainer;

    public ClientsController() {
        ClientsDIContainer clientsDIContainer = new ClientsDIContainer();
        this.contextContainer = new ContextContainer(
                clientsDIContainer.getClientsService(),
                clientsDIContainer.getRequestParser(),
                clientsDIContainer.getClientsConverter(),
                clientsDIContainer.getClientsValidator()
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
