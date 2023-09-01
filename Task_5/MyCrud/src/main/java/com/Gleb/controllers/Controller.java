package com.Gleb.controllers;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.exceptions.ConversionException;
import com.Gleb.exceptions.ParsingException;
import com.Gleb.exceptions.ValidationException;
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

            validator.validateId(id);

            Object entity = service.get(id);
            if (entity == null) {
                resp.setStatus(500);
                return;
            }

            String jsonEntity = converter.convertToJson(entity);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter out;
            out = resp.getWriter();
            out.print(jsonEntity);
            out.flush();

            resp.setStatus(200);
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
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }

    default void handlePost(HttpServletRequest req, HttpServletResponse resp, Service service,
                            Converter converter, Validator validator, RequestParser requestParser) {
        try {
            String reqBody = requestParser.getRequestBody(req);

            Object entity = converter.convertFromJson(reqBody);

            validator.validateForAdd(entity);

            if (!service.add(entity)) {
                resp.setStatus(500);
                return;
            }

            resp.setStatus(201);
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
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }

    default void handlePut(HttpServletRequest req, HttpServletResponse resp, Service service,
                           Converter converter, Validator validator, RequestParser requestParser) {
        try {
            String reqBody = requestParser.getRequestBody(req);

            Object entity = converter.convertFromJson(reqBody);

            validator.validateForUpdate(entity);

            if (!service.update(entity)) {
                resp.setStatus(500);
                return;
            }

            resp.setStatus(204);
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
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }

    default void handleDelete(HttpServletRequest req, HttpServletResponse resp, Service service,
                              Validator validator, RequestParser requestParser) {
        try {
            Integer id = requestParser.getId(req);

            validator.validateId(id);

            if (!service.delete(id)) {
                resp.setStatus(500);
                return;
            }

            resp.setStatus(204);
        }
        catch (ValidationException e) {
            // обработка
        }
        catch (ParsingException e) {
            // обработка
        }
        catch (Exception e) {
            // обработка всех видов ошибок из домена
        }
    }
}
