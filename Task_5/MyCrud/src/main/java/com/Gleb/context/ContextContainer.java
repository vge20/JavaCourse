package com.Gleb.context;

import com.Gleb.RequestParser;
import com.Gleb.converters.Converter;
import com.Gleb.services.Service;
import com.Gleb.validators.Validator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContextContainer<T> {

    private Service<T> service;

    private RequestParser requestParser;

    private Converter<T> converter;

    private Validator validator;
}
