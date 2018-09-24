package com.atmi.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

/**
 * @author 猪小马
 */
@Controller
public class HelloControl {

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello", "jack");
        return "success";
    }
}
