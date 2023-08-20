package com.Gleb;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/run")
public class Controller extends HttpServlet {
    public Controller() {
        this.requestPrinter = new RequestPrinter();
    }

    private RequestPrinter requestPrinter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        requestPrinter.printAllInformation(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        requestPrinter.printAllInformation(req);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        requestPrinter.printAllInformation(req);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        requestPrinter.printAllInformation(req);
    }
}
