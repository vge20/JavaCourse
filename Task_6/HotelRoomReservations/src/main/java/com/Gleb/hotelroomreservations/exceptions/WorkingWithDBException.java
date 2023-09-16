package com.Gleb.hotelroomreservations.exceptions;

public class WorkingWithDBException extends BaseException {

    private String jsonMessage;

    public WorkingWithDBException() {
        jsonMessage = "{\"message\":\"Ошибка при работе с БД!\"}";
    }


    public String getJsonMessage() {
        return jsonMessage;
    }
}
