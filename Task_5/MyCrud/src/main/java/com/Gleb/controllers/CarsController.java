package com.Gleb.controllers;

import com.Gleb.entities.Car;
import com.Gleb.repositories.CarsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.stream.Collectors;

@WebServlet("/cars")
public class CarsController extends HttpServlet {

    private CarsRepository carsRepository;

    public CarsController() { this.carsRepository = new CarsRepository(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            if (id < 0) { throw new Exception(); }
        }
        catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        Car car;
        try {
            car = carsRepository.getCarById(id);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out;
        String jsonClient;
        try {
            out = resp.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            jsonClient = objectMapper.writeValueAsString(car);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        out.print(jsonClient);
        out.flush();
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car;
        try {
            car = objectMapper.readValue(req.getReader().lines().collect(Collectors.joining("\n")),
                    Car.class);
            car.getBrand();
            car.getColor(); // проверка ввода из json
            if (car.getEngineCapacity() < 0) { throw new Exception(); }
            Date.valueOf(car.getManufactureDate());
            if (car.getPrice() < 0) { throw new Exception(); }
        } catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            carsRepository.addCar(car);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

        ObjectMapper objectMapper = new ObjectMapper();
        Car car;
        try {
            car = objectMapper.readValue(req.getReader().lines().collect(Collectors.joining("\n")),
                    Car.class);
            if (car.getId() < 0) { throw new Exception(); }
            car.getBrand();
            car.getColor(); // проверка ввода из json
            if (car.getEngineCapacity() < 0) { throw new Exception(); }
            Date.valueOf(car.getManufactureDate());
            if (car.getPrice() < 0) { throw new Exception(); }
        } catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            carsRepository.updateCar(car);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            if (id < 0) { throw new Exception(); }
        }
        catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            carsRepository.deleteCar(id);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }
}
