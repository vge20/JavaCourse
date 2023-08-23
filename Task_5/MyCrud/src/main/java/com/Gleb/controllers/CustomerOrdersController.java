package com.Gleb.controllers;

import com.Gleb.entities.CustomerOrder;
import com.Gleb.repositories.CustomerOrdersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.stream.Collectors;

@WebServlet("/customer_orders")
public class CustomerOrdersController extends HttpServlet {

    private CustomerOrdersRepository customerOrdersRepository;

    public CustomerOrdersController() { this.customerOrdersRepository = new CustomerOrdersRepository(); }

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

        CustomerOrder customerOrder;
        try {
            customerOrder = customerOrdersRepository.getCustomerOrderById(id);
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
            jsonClient = objectMapper.writeValueAsString(customerOrder);
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
        CustomerOrder customerOrder;
        try {
            customerOrder = objectMapper.readValue(req.getReader().lines().collect(Collectors.joining("\n")),
                    CustomerOrder.class);
            if (customerOrder.getClientId() < 0) { throw new Exception(); }
            if (customerOrder.getCarId() < 0) { throw new Exception(); }
            Date.valueOf(customerOrder.getOrderDate()); // проверка ввода из json
        } catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            customerOrdersRepository.addCustomerOrder(customerOrder);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerOrder customerOrder;
        try {
            customerOrder = objectMapper.readValue(req.getReader().lines().collect(Collectors.joining("\n")),
                    CustomerOrder.class);
            if (customerOrder.getId() < 0) { throw new Exception(); }
            if (customerOrder.getClientId() < 0) { throw new Exception(); }
            if (customerOrder.getCarId() < 0) { throw new Exception(); }
            Date.valueOf(customerOrder.getOrderDate()); // проверка ввода из json
        } catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            customerOrdersRepository.updateCustomerOrder(customerOrder);
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
            customerOrdersRepository.deleteClient(id);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }
}
