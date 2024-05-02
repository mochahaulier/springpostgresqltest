package dev.mochahaulier.springpostgresqltest.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TodoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TodoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionMap(TodoNotFoundException exception) {
        Map<String, String> exceptionMap = new HashMap<>();
        exceptionMap.put("errorMsg: ", exception.getMessage());
        return exceptionMap;
    }

}
