package com.Gleb;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class View {

    public void outputRequestMethod(HttpServletRequest req) {
        System.out.println("Тип запроса: " + req.getMethod());
    }

    public void outputRequestURI(HttpServletRequest req) {
        System.out.println("URI запроса: " + req.getRequestURI());
    }

    public void outputRequestHeaders(HttpServletRequest req) {
        System.out.println("Заголовки запроса: ");
        Enumeration<String> headerNamesForPrint = req.getHeaderNames();
        Enumeration<String> headerNamesForGetHeaders = req.getHeaderNames();
        if (headerNamesForPrint != null) {
            while (headerNamesForPrint.hasMoreElements()) {
                System.out.println(headerNamesForPrint.nextElement() + " = " +
                            req.getHeader(headerNamesForGetHeaders.nextElement()));

            }
        }
    }

    public void outputRequestParameters(HttpServletRequest req) {
        System.out.println("Параметры запроса: ");
        Enumeration<String> parameterNamesForPrint = req.getParameterNames();
        Enumeration<String> parameterNamesForGetParameters = req.getParameterNames();
        if (parameterNamesForPrint != null) {
            while ((parameterNamesForPrint.hasMoreElements())) {
                System.out.println(parameterNamesForPrint.nextElement() + " = " +
                        req.getParameter(parameterNamesForGetParameters.nextElement()));
            }
        }
    }

    public void outputRequestBody(HttpServletRequest req) throws IOException {
        System.out.println("Тело запроса: " + req.getReader().readLine());
    }
}
