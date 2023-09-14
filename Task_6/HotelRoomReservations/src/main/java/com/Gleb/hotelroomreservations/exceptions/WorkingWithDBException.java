package com.Gleb.hotelroomreservations.exceptions;

public class WorkingWithDBException extends BaseException {

    private String message;

    public WorkingWithDBException() {
        message = "Ошибка при работе с БД!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
