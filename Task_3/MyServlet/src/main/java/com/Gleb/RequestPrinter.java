package com.Gleb;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class View {

    public void outputRequestMethod(HttpServletRequest req) {
        System.out.println("Тип запроса: " + req.getMethod());
    }

    public void outputRequestURI(HttpServletRequest req) {
        System.out.println("URI запроса: " + req.getRequestURI());
    }

    public void outputRequestHeaders(HttpServletRequest req) {
        System.out.println("Заголовки запроса: ");
        Enumeration<String> headerNames = req.getHeaderNames();
        String headerName;
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                headerName = headerNames.nextElement();
                System.out.println(headerName + " = " +
                            req.getHeader(headerName));

            }
        }
    }

    public void outputRequestParameters(HttpServletRequest req) {
        System.out.println("Параметры запроса: ");
        Enumeration<String> parameterNames = req.getParameterNames();
        String parameterName;
        if (parameterNames != null) {
            while ((parameterNames.hasMoreElements())) {
                parameterName = parameterNames.nextElement();
                System.out.println(parameterName + " = " +
                        req.getParameter(parameterName));
            }
        }
    }

    public void outputRequestBody(HttpServletRequest req) {
        try {
            System.out.println("Тело запроса: " + req.getReader().lines().collect(Collectors.joining("\n")));
        } catch (Exception e) {
            System.out.println("Ошибка чтения тела запроса!");
        }
    }

    public void outputAllInformation(HttpServletRequest req) {
        this.outputRequestMethod(req);
        this.outputRequestURI(req);
        this.outputRequestHeaders(req);
        this.outputRequestBody(req);
        this.outputRequestParameters(req);
    }
}
