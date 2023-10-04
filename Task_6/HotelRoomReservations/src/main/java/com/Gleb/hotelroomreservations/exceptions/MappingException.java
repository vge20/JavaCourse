package com.Gleb.hotelroomreservations.exceptions;

public class MappingException extends BaseException {

    private String template;

    public MappingException() {
        template = "exceptions/mappingException";
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
