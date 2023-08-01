package com.Gleb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/doSomething")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestURI().toString();
        //req.getMethod().toString();
        //req.getParameter("param").toString();
        //req.getHeader("MyHeader").toString();
        //req.getReader().toString(); // ?? и надо ли везде toString()?
        System.out.println("AAA");
    }
}
