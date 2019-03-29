package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
//    @RequestMapping(value = "/main")
//    public String main(){
//        return "list";
//    }
    @PostMapping(value = "/user/login")
    public String login(HttpSession session,
            @RequestParam("username") String username,@RequestParam("password") String password,
            Map<String,Object> map){
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)
             && "admin".equals(username)  && "123".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码不正确。");
        return "login";
    }
}
