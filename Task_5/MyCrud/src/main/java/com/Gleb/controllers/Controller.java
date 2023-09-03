package com.Gleb.controllers;

import com.Gleb.context.ContextContainer;
import com.Gleb.exceptions.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {

    private void writeExceptionMessage(String message, HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            resp.setStatus(500);
        }
        out.print(String.format("\"Message\":\"%s\"", message));
        out.flush();
    }

    protected void handleGet(HttpServletRequest req, HttpServletResponse resp, ContextContainer contextContainer) {
        try {
            Integer id = contextContainer.getRequestParser().getId(req);

            contextContainer.getValidator().validateId(id);

            Object entity = contextContainer.getService().get(id);

            String jsonEntity = contextContainer.getConverter().convertToJson(entity);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter out = null;
            try {
                out = resp.getWriter();
            } catch (IOException e) {
                resp.setStatus(500);
            }
            out.print(jsonEntity);
            out.flush();

            if (resp.getStatus() != 500) {
                resp.setStatus(200);
            }
        }
        catch (WorkingWithDBException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            resp.setStatus(500);
        }
        catch (BaseException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            if (resp.getStatus() != 500) {
                resp.setStatus(400);
            }
        }
    }

    protected void handlePost(HttpServletRequest req, HttpServletResponse resp, ContextContainer contextContainer) {
        try {
            String reqBody = contextContainer.getRequestParser().getRequestBody(req);

            Object entity = contextContainer.getConverter().convertFromJson(reqBody);

            contextContainer.getValidator().validateForAdd(entity);

            contextContainer.getService().add(entity);

            resp.setStatus(201);
        }
        catch (WorkingWithDBException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            resp.setStatus(500);
        }
        catch (BaseException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            if (resp.getStatus() != 500) {
                resp.setStatus(400);
            }
        }
    }

    protected void handlePut(HttpServletRequest req, HttpServletResponse resp, ContextContainer contextContainer) {
        try {
            String reqBody = contextContainer.getRequestParser().getRequestBody(req);

            Object entity = contextContainer.getConverter().convertFromJson(reqBody);

            contextContainer.getValidator().validateForUpdate(entity);

            contextContainer.getService().update(entity);

            resp.setStatus(204);
        }
        catch (WorkingWithDBException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            resp.setStatus(500);
        }
        catch (BaseException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            if (resp.getStatus() != 500) {
                resp.setStatus(400);
            }
        }
    }

    protected void handleDelete(HttpServletRequest req, HttpServletResponse resp, ContextContainer contextContainer) {
        try {
            Integer id = contextContainer.getRequestParser().getId(req);

            contextContainer.getValidator().validateId(id);

            contextContainer.getService().delete(id);

            resp.setStatus(204);
        }
        catch (WorkingWithDBException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            resp.setStatus(500);
        }
        catch (BaseException e) {
            this.writeExceptionMessage(e.getMessage(), resp);
            if (resp.getStatus() != 500) {
                resp.setStatus(400);
            }
        }
    }
}
