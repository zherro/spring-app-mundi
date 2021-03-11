package br.com.zherro.springmundi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public  String hello(HttpServletRequest request){
        request.setAttribute("name", "World");
        return "hello";
    }

    @GetMapping("/hello2")
    public  String hello(Model model){
        model.addAttribute("name", "World 2");
        return "hello";
    }
}
