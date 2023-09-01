package com.Gleb.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    default void handleGet(HttpServletRequest req, HttpServletResponse resp, ) throws Exception {

    }
}
