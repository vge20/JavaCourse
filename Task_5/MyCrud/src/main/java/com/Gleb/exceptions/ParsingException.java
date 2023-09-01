package com.Gleb.exceptions;

public class ParsingException extends Exception {

    private String message;

    public ParsingException() {
        message = "Ошибка парсинга http-запроса!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
