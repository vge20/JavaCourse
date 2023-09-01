package com.Gleb;

import com.Gleb.exceptions.ParsingException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class RequestParser {

    public Integer getId(HttpServletRequest req) throws ParsingException {
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }
        catch (Exception e) {
            throw new ParsingException();
        }

        return id;
    }

    public String getRequestBody(HttpServletRequest req) throws ParsingException {
        String reqBody;
        try {
             reqBody = req.getReader().lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new ParsingException();
        }

        return reqBody;
    }
}
