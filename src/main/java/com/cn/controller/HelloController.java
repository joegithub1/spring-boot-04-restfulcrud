package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("msg","成功");
        map.put("hello","<h1>Hello World</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        //默认道 templates/success.html
        return "success";
    }


}
