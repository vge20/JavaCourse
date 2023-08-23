package com.Gleb.controllers;

import com.Gleb.entities.Client;
import com.Gleb.repositories.ClientsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.stream.Collectors;

@WebServlet("/clients")
public class ClientsController extends HttpServlet {

    private ClientsRepository clientsRepository;

    public ClientsController() {
        this.clientsRepository = new ClientsRepository();
    }

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
                    Client.class);
            client.getFullName();  // проверка, что нужные параметры переданы в json
            client.getGender();    // если их не передано, то будет Exception
            Date.valueOf(client.getDateBirth()); // проверка валидности даты в json
        } catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            clientsRepository.addClient(client);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {

        ObjectMapper objectMapper = new ObjectMapper();
        Client client;
        try {
            client = objectMapper.readValue(req.getReader().lines().collect(Collectors.joining("\n")),
                    Client.class);
            if (client.getId() < 0) { throw new Exception(); }
            client.getFullName(); // проверка, что все нужные параметры были переданы,
            client.getGender();   // а также их валидности
            Date.valueOf(client.getDateBirth());
        } catch (Exception e) {
            resp.setStatus(400);
            return;
        }

        try {
            clientsRepository.updateClient(client);
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
            clientsRepository.deleteClient(id);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }
}
