package com.Gleb.hotelroomreservations.exceptions;

public class ValidationException extends BaseException {

    private String jsonMessage;

    public ValidationException() {
        jsonMessage = "{\"message\":\"Ошибка валидации!\"}";
    }


    public String getJsonMessage() {
        return jsonMessage;
    }
}
