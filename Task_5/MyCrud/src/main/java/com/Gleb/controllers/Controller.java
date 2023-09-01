package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public interface Controller {

    default void handleGet(HttpServletRequest req, HttpServletResponse resp, Service service,
                           Converter converter, Validator validator, RequestParser requestParser) {
        try {
            Integer id = requestParser.getId(req);
            if (id == null) {
                resp.setStatus(400);
                return;
            }

            if (!validator.validateId(id)) {
                resp.setStatus(400);
                return;
            }

            Object entity = service.get(id);
            if (entity == null) {
                resp.setStatus(500);
                return;
            }

            String jsonEntity = converter.convertToJson(entity);
            if (jsonEntity == null) {
                resp.setStatus(500);
                return;
            }

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter out;
            out = resp.getWriter();
            out.print(jsonEntity);
            out.flush();

            resp.setStatus(200);
        }
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }

    default void handlePost(HttpServletRequest req, HttpServletResponse resp, Service service,
                            Converter converter, Validator validator, RequestParser requestParser) {
        try {
            String reqBody = requestParser.getRequestBody(req);
            if (reqBody == null) {
                resp.setStatus(400);
                return;
            }

            Object entity = converter.convertFromJson(reqBody);
            if (entity == null) {
                resp.setStatus(400);
                return;
            }

            if (!validator.validateForAdd(entity)) {
                resp.setStatus(400);
                return;
            }

            if (!service.add(entity)) {
                resp.setStatus(500);
                return;
            }

            resp.setStatus(201);
        }
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }

    default void handlePut(HttpServletRequest req, HttpServletResponse resp, Service service,
                           Converter converter, Validator validator, RequestParser requestParser) {
        try {
            String reqBody = requestParser.getRequestBody(req);
            if (reqBody == null) {
                resp.setStatus(400);
                return;
            }

            Object entity = converter.convertFromJson(reqBody);
            if (entity == null) {
                resp.setStatus(400);
                return;
            }

            if (!validator.validateForUpdate(entity)) {
                resp.setStatus(400);
                return;
            }

            if (!service.update(entity)) {
                resp.setStatus(500);
                return;
            }

            resp.setStatus(204);
        }
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }

    default void handleDelete(HttpServletRequest req, HttpServletResponse resp, Service service,
                              Validator validator, RequestParser requestParser) {
        try {
            Integer id = requestParser.getId(req);
            if (id == null) {
                resp.setStatus(400);
                return;
            }

            if (!validator.validateId(id)) {
                resp.setStatus(400);
                return;
            }

            if (!service.delete(id)) {
                resp.setStatus(500);
                return;
            }

            resp.setStatus(204);
        }
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }
}
