package com.Gleb.exceptions;

public class DoesNotExistRecordException extends BaseException {

    private String message;

    public DoesNotExistRecordException() {
        message = "Не существует записи с указанными параметрами!";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
