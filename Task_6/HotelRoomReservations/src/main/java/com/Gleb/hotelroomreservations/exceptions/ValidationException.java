package com.Gleb.hotelroomreservations.exceptions;

public class ValidationException extends BaseException {

    private String message;

    public ValidationException() {
        message = "message:Ошибка валидации!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
