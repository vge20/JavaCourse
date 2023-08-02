package com.Gleb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/run")
public class Controller extends HttpServlet {
    public Controller() {
        this.view = new View();
    }
    private View view;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        view.outputRequestMethod(req);
        view.outputRequestURI(req);
        view.outputRequestHeaders(req);
        view.outputRequestParameters(req);
        view.outputRequestBody(req);
    }
}
