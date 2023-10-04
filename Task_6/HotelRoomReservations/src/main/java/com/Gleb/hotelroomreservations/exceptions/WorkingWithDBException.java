package com.Gleb.hotelroomreservations.exceptions;

public class WorkingWithDBException extends BaseException {

    private String template;

    public WorkingWithDBException() {
        template = "exceptions/workingWithDBException";
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
