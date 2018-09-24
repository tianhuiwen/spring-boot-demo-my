package com.atmi.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 猪小马
 */
@Controller
public class LoginControl {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        String userpassword = "12345";
        if (!StringUtils.isEmpty(username) && userpassword.equals(password)) {
            session.setAttribute("loginuser", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
