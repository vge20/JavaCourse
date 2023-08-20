package com.Gleb;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.stream.Collectors;

public class RequestPrinter {

    public RequestPrinter() {
        printerCacheKeeper = new PrinterCacheKeeper();
    }

    private PrinterCacheKeeper printerCacheKeeper;

    public void printRequestMethod(HttpServletRequest req) {
        String outputString = "Тип запроса:\n" + req.getMethod();
        System.out.println(outputString);
        printerCacheKeeper.add(outputString);
    }

    public void printRequestURI(HttpServletRequest req) {
        String outputString = "URI запроса:\n" + req.getRequestURI();
        System.out.println(outputString);
        printerCacheKeeper.add(outputString);
    }

    public void printRequestHeaders(HttpServletRequest req) {
        System.out.println("Заголовки запроса: ");
        printerCacheKeeper.add("Заголовки запроса: ");
        Enumeration<String> headerNames = req.getHeaderNames();
        String headerName;
        String outputString;
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                headerName = headerNames.nextElement();
                outputString = headerName + " = " + req.getHeader(headerName);
                System.out.println(outputString);
                printerCacheKeeper.add(outputString);
            }
        }
    }

    public void printRequestParameters(HttpServletRequest req) {
        System.out.println("Параметры запроса: ");
        printerCacheKeeper.add("Параметры запроса: ");
        Enumeration<String> parameterNames = req.getParameterNames();
        String parameterName;
        String outputString;
        if (parameterNames != null) {
            while ((parameterNames.hasMoreElements())) {
                parameterName = parameterNames.nextElement();
                outputString = parameterName + " = " + req.getParameter(parameterName);
                System.out.println(outputString);
                printerCacheKeeper.add(outputString);
            }
        }
    }

    public void printRequestBody(HttpServletRequest req) {
        try {
            String outputString = "Тело запроса:\n" + req.getReader().lines().collect(Collectors.joining("\n"));
            System.out.println(outputString);
            printerCacheKeeper.add(outputString);
        } catch (Exception e) {
            System.out.println("Ошибка чтения тела запроса!");
        }
    }

    public void printAllInformation(HttpServletRequest req) {
        for (String string : printerCacheKeeper.getPrinterCache()) {
            System.out.println(string);
        }

        this.printRequestMethod(req);
        this.printRequestURI(req);
        this.printRequestHeaders(req);
        this.printRequestBody(req);
        this.printRequestParameters(req);
    }
}
