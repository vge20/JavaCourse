package com.Gleb.hotelroomreservations.exceptions;

public class AuthenticationException extends BaseException {

    private String jsonMessage;

    public AuthenticationException() {
        jsonMessage = "{\"message\":\"Ошибка аутентификации!\"}";
    }

    @Override
    public String getJsonMessage() {
        return jsonMessage;
    }
}
