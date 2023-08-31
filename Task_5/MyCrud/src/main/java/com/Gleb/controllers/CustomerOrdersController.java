package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.CustomerOrdersConverter;
import com.Gleb.entities.CustomerOrder;
import com.Gleb.services.CustomerOrdersService;
import com.Gleb.validators.CustomerOrdersValidator;
import com.Gleb.validators.Validator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/customer_orders")
public class CustomerOrdersController extends HttpServlet {

    private CustomerOrdersService customerOrdersService;

    private RequestParser requestParser;

    private CustomerOrdersConverter customerOrdersConverter;

    private CustomerOrdersValidator customerOrdersValidator;

    public CustomerOrdersController() {
        this.customerOrdersService = new CustomerOrdersService();
        this.requestParser = new RequestParser();
        this.customerOrdersConverter = new CustomerOrdersConverter();
        this.customerOrdersValidator = new CustomerOrdersValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        Integer id = requestParser.getId(req);
        if (id == null) {
            resp.setStatus(400);
            return;
        }

        if (!customerOrdersValidator.validateId(id)) {
            resp.setStatus(400);
            return;
        }

        CustomerOrder customerOrder = customerOrdersService.getCustomerOrder(id);
        if (customerOrder == null) {
            resp.setStatus(500);
            return;
        }

        String jsonCustomerOrder = customerOrdersConverter.convertToJson(customerOrder);
        if (jsonCustomerOrder == null) {
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
        out.print(jsonCustomerOrder);
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

        CustomerOrder customerOrder = customerOrdersConverter.convertFromJson(reqBody);
        if (customerOrder == null) {
            resp.setStatus(400);
            return;
        }

        if (!customerOrdersValidator.validateForAdd(customerOrder)) {
            resp.setStatus(400);
            return;
        }

        if (!customerOrdersService.addCustomerOrder(customerOrder)) {
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

        CustomerOrder customerOrder = customerOrdersConverter.convertFromJson(reqBody);
        if (customerOrder == null) {
            resp.setStatus(400);
            return;
        }

        if (!customerOrdersValidator.validateForUpdate(customerOrder)) {
            resp.setStatus(400);
            return;
        }

        if (!customerOrdersService.updateCustomerOrder(customerOrder)) {
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

        if (!customerOrdersValidator.validateId(id)) {
            resp.setStatus(400);
            return;
        }

        if (!customerOrdersService.deleteCustomerOrder(id)) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(204);
    }
}
