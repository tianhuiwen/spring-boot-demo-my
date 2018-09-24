package com.atmi.springboot.control;

import com.atmi.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 猪小马
 */
@ControllerAdvice
public class MyExecepionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<Object, Object> handleExeception(Exception e){
        Map<Object, Object> map = new HashMap<>(20);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        return map;
    }
}
