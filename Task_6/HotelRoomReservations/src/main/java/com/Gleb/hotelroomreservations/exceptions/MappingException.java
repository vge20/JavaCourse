package com.Gleb.hotelroomreservations.exceptions;

public class MappingException extends BaseException {

    private String message;

    public MappingException() {
        message = "message:Ошибка отображения данных!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
