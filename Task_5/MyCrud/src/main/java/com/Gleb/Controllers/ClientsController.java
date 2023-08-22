package com.Gleb.Controllers;

import com.Gleb.BLObjects.Client;
import com.Gleb.DBConnection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        }
        catch (Exception e) {
            resp.setStatus(400);
            return;
        }
        if (id == null) {
            resp.setStatus(400);
            return;
        }

        Client client = new Client();
        Connection connection = null;
        Statement statement = null;
        ResultSet queryRes = null;

        try {
            connection = DBConnection.getConnection();

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            queryRes = statement.executeQuery("select * from clients c where c.id = " + id);

            if (queryRes.next()) {
                client.setId(queryRes.getInt("id"));
                client.setFullName(queryRes.getString("full_name"));
                client.setDateBirth(queryRes.getDate("date_birth"));
                client.setGender(queryRes.getBoolean("gender"));
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e) {
            resp.setStatus(500);
        }

        try {
            if (queryRes != null) { queryRes.close(); }
            if (statement != null) { statement.close(); }
            if (connection != null) { connection.close(); }
        } catch (SQLException e) {
            resp.setStatus(500);
        }

        if (resp.getStatus() == 500) { return; }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out;
        try {
            out = resp.getWriter();
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        String jsonClient;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonClient = objectMapper.writeValueAsString(client);
        } catch (JsonProcessingException e) {
            resp.setStatus(500);
            return;
        }

        out.print(jsonClient);
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
