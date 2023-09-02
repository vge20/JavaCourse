package com.Gleb.exceptions;

public class ValidationException extends BaseException {

    private String message;

    public ValidationException() {
        message = "Ошибка валидации тела или параметров http-запроса!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
