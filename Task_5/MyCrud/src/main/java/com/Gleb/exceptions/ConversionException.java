package com.Gleb.exceptions;

public class ConversionException extends Exception {

    private String message;

    public ConversionException() {
        message = "Ошибка конвертации данных между json и сущностью бизнес-логики!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
