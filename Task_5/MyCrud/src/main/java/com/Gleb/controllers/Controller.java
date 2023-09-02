package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.exceptions.*;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public interface Controller {

    default void writeExceptionMessage(String message, HttpServletResponse resp) {
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

    default void handleGet(HttpServletRequest req, HttpServletResponse resp, Service service,
                           Converter converter, Validator validator, RequestParser requestParser) {
        try {
            Integer id = requestParser.getId(req);

            validator.validateId(id);

            Object entity = service.get(id);

            String jsonEntity = converter.convertToJson(entity);

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

    default void handlePost(HttpServletRequest req, HttpServletResponse resp, Service service,
                            Converter converter, Validator validator, RequestParser requestParser) {
        try {
            String reqBody = requestParser.getRequestBody(req);

            Object entity = converter.convertFromJson(reqBody);

            validator.validateForAdd(entity);

            service.add(entity);

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

    default void handlePut(HttpServletRequest req, HttpServletResponse resp, Service service,
                           Converter converter, Validator validator, RequestParser requestParser) {
        try {
            String reqBody = requestParser.getRequestBody(req);

            Object entity = converter.convertFromJson(reqBody);

            validator.validateForUpdate(entity);

            service.update(entity);

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

    default void handleDelete(HttpServletRequest req, HttpServletResponse resp, Service service,
                              Validator validator, RequestParser requestParser) {
        try {
            Integer id = requestParser.getId(req);

            validator.validateId(id);

            service.delete(id);

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
