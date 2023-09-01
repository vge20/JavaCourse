package com.Gleb.exceptions;

public class ValidationException extends Exception {

    private String message;

    public ValidationException() {
        message = "Ошибка валидации тела или параметров http-запроса!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
