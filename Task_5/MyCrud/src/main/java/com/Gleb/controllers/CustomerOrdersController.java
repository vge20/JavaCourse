package com.Gleb.controllers;

import com.Gleb.containers.ContextContainer;
import com.Gleb.containers.CustomerOrdersDIContainer;
import com.Gleb.entities.CustomerOrder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/customer_orders")
public class CustomerOrdersController extends Controller {

    private ContextContainer<CustomerOrder> contextContainer;

    public CustomerOrdersController() {
        CustomerOrdersDIContainer customerOrdersDIContainer = new CustomerOrdersDIContainer();
        this.contextContainer = new ContextContainer(
                customerOrdersDIContainer.getCustomerOrdersService(),
                customerOrdersDIContainer.getRequestParser(),
                customerOrdersDIContainer.getCustomerOrdersConverter(),
                customerOrdersDIContainer.getCustomerOrdersValidator()
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
