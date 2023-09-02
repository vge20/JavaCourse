package com.Gleb.controllers;

import com.Gleb.containers.CarsDIContainer;
import com.Gleb.containers.ContextContainer;
import com.Gleb.entities.Car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarsController extends Controller {

    private ContextContainer<Car> contextContainer;

    public CarsController() {
        CarsDIContainer carsDIContainer = new CarsDIContainer();
        this.contextContainer = new ContextContainer(
                carsDIContainer.getCarsService(),
                carsDIContainer.getRequestParser(),
                carsDIContainer.getCarsConverter(),
                carsDIContainer.getCarsValidator()
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
