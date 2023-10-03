package com.Gleb.hotelroomreservations.exceptions;

public class AuthenticationException extends BaseException {

    private String message;

    public AuthenticationException() {
        message = "message:Ошибка аутентификации!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
