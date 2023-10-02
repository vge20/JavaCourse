package com.Gleb.hotelroomreservations.exceptions;

public class AuthenticationException extends BaseException {

    private String jsonMessage;

    public AuthenticationException() {
        jsonMessage = "{\"message\":\"Ошибка отображения данных!\"}";
    }

    @Override
    public String getJsonMessage() {
        return jsonMessage;
    }
}
