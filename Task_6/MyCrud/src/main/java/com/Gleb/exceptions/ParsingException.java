package com.Gleb.exceptions;

public class ParsingException extends BaseException {

    private String message;

    public ParsingException() {
        message = "Ошибка парсинга http-запроса!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
