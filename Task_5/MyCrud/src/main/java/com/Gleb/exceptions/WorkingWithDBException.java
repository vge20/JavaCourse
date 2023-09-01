package com.Gleb.exceptions;

public class WorkingWithDBException extends Exception {

    private String message;

    public WorkingWithDBException() {
        message = "Ошибка при работе с БД!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
