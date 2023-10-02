package com.Gleb.hotelroomreservations.exceptions;

public class MappingException extends BaseException {

    private String jsonMessage;

    public MappingException() {
        jsonMessage = "{\"message\":\"Ошибка отображения данных!\"}";
    }

    @Override
    public String getJsonMessage() {
        return jsonMessage;
    }
}
