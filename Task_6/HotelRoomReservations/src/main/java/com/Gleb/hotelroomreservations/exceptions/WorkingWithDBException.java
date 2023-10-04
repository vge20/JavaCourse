package com.Gleb.hotelroomreservations.exceptions;

public class WorkingWithDBException extends BaseException {

    private String message;

    public WorkingWithDBException() {
        message = "message:Ошибка при работе c БД!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
