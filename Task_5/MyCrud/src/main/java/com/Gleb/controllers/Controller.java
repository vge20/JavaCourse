package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.exceptions.ConversionException;
import com.Gleb.exceptions.ParsingException;
import com.Gleb.exceptions.ValidationException;
import com.Gleb.exceptions.WorkingWithDBException;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public interface Controller {

    default void handleGet(HttpServletRequest req, HttpServletResponse resp, Service service,
                           Converter converter, Validator validator, RequestParser requestParser) {
        try {
            Integer id = requestParser.getId(req);

            validator.validateId(id);

            Object entity = service.get(id);

            String jsonEntity = converter.convertToJson(entity);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter out;
            out = resp.getWriter();
            out.print(jsonEntity);
            out.flush();

            resp.setStatus(200);
        }
        catch (WorkingWithDBException e) {
            // обработка
        }
        catch (ValidationException e) {
            // обработка
        }
        catch (ParsingException e) {
            // обработка
        }
        catch (ConversionException e) {
            // обработка
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            // обработка
        }
        catch (ValidationException e) {
            // обработка
        }
        catch (ParsingException e) {
            // обработка
        }
        catch (ConversionException e) {
            // обработка
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
            // обработка
        }
        catch (ValidationException e) {
            // обработка
        }
        catch (ParsingException e) {
            // обработка
        }
        catch (ConversionException e) {
            // обработка
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
            // обработка
        }
        catch (ValidationException e) {
            // обработка
        }
        catch (ParsingException e) {
            // обработка
        }
    }
}
