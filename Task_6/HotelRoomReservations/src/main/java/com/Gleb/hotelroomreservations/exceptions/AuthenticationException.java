package com.Gleb.hotelroomreservations.exceptions;

public class AuthenticationException extends BaseException {

    private String template;

    public AuthenticationException() {
        template = "exceptions/authenticationException";
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
