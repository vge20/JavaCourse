package com.Gleb.Controllers;

import com.Gleb.BLObjects.Client;
import com.Gleb.Repositories.ClientsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/clients")
public class ClientsController extends HttpServlet {

    private ClientsRepository clientsRepository;

    public ClientsController() {
        clientsRepository = new ClientsRepository();
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
        } catch (IOException e) {
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
        } catch (IOException e) {
            resp.setStatus(400);
            return;
        } // тут если не передать id, то это выяснится только при запросе

        try {
            clientsRepository.updateClient(client);
        } catch (Exception e) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    } // тут и в POST

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
