package com.Gleb;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class RequestParser {

    public Integer getId(HttpServletRequest req) {
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }
        catch (Exception e) {
            return null;
        }

        return id;
    }

    public String getRequestBody(HttpServletRequest req) {
        String reqBody;
        try {
             reqBody = req.getReader().lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            return null;
        }

        return reqBody;
    }
}
