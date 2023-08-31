package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.CarsConverter;
import com.Gleb.entities.Car;
import com.Gleb.services.CarsService;
import com.Gleb.validators.CarsValidator;
import com.Gleb.validators.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cars")
public class CarsController extends HttpServlet {

    private CarsService carsService;

    private RequestParser requestParser;

    private CarsConverter carsConverter;

    private CarsValidator carsValidator;

    public CarsController() {
        this.requestParser = new RequestParser();
        this.carsService = new CarsService();
        this.carsConverter = new CarsConverter();
        this.carsValidator = new CarsValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        Integer id = requestParser.getId(req);
        if (id == null) {
            resp.setStatus(400);
            return;
        }

        if (!carsValidator.validateId(id)) {
            resp.setStatus(400);
            return;
        }

        Car car = carsService.getCar(id);
        if (car == null) {
            resp.setStatus(500);
            return;
        }

        String jsonCar = carsConverter.convertToJson(car);
        if (jsonCar == null) {
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
        out.print(jsonCar);
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

        Car car = carsConverter.convertFromJson(reqBody);
        if (car == null) {
            resp.setStatus(400);
            return;
        }

        if (!carsValidator.validateForAdd(car)) {
            resp.setStatus(400);
            return;
        }

        if (!carsService.addCar(car)) {
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

        Car car = carsConverter.convertFromJson(reqBody);
        if (car == null) {
            resp.setStatus(400);
            return;
        }

        if (!carsValidator.validateForUpdate(car)) {
            resp.setStatus(400);
            return;
        }

        if (!carsService.updateCar(car)) {
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

        if (!carsValidator.validateId(id)) {
            resp.setStatus(400);
            return;
        }

        if (!carsService.deleteCar(id)) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(204);
    }
}
