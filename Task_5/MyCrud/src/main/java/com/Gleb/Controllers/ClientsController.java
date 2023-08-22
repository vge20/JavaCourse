package com.Gleb;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

@WebServlet("/clients")
public class ClientsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id;
        try {
            id = req.getParameter("id");
            System.out.println(id);
        }
        catch (Exception e) {
            resp.setStatus(400);
            return;
        }
        if (id == null) {
            resp.setStatus(400);
            return;
        }

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Properties authorization = new Properties();
            authorization.put("user", "postgres");
            authorization.put("password", "postgres");

            Connection connection = DriverManager.getConnection(url, authorization);

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet table = statement.executeQuery("select * from clients c where c.id = " + id);

            if (table != null) { table.close(); }
            if (statement != null) { statement.close(); }
            if (connection != null) { connection.close(); }
        }
        catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setContentType("application/json");
        PrintWriter out;
        try {
            out = resp.getWriter();
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }
        resp.setCharacterEncoding("UTF-8");
        out.print("{key: value}");
        out.flush();
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

    }
}
