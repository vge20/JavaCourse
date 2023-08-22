package com.Gleb.Controllers;

import com.Gleb.BLObjects.Client;
import com.Gleb.DBConnection;
import com.Gleb.Repositories.ClientsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.stream.Collectors;

@WebServlet("/clients")
public class ClientsController extends HttpServlet {

    private ClientsRepository clientsRepository;

    public ClientsController() {
        clientsRepository = new ClientsRepository();
    }

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

        Client client;
        try {
            client = clientsRepository.getClientById(id);
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
            jsonClient = objectMapper.writeValueAsString(client);
        }  catch (JsonProcessingException e) {
            resp.setStatus(500);
            return;
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
        Client client;
        try {
            client = objectMapper.readValue(req.getReader().lines().collect(Collectors.joining("\n")),
                    Client.class); // а может проблема с joining или с тем как посылаю json
        } catch (IOException e) {
            resp.setStatus(400);
            return;
        }

        System.out.println("AAA");
    } // там со считыванием дота рождения есть неполадки, мб при считывании сразу конвертить в String

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

    }
}
