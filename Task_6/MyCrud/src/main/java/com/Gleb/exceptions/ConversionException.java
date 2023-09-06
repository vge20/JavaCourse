package com.Gleb.exceptions;

public class ConversionException extends BaseException {

    private String message;

    public ConversionException() {
        message = "Ошибка конвертации данных между json и сущностью бизнес-логики!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
