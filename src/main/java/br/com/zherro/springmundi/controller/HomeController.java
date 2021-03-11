package br.com.zherro.springmundi.controller;

import br.com.zherro.springmundi.model.Order;
import br.com.zherro.springmundi.model.OrderStatus;
import br.com.zherro.springmundi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String home(Model model){

        List<Order> orders = orderService.orderList();
        model.addAttribute("orders", orders);

        return "home";
    }

    @GetMapping("/home")
    public String homeByUrl(Model model){

        List<Order> orders = orderService.orderList();
        model.addAttribute("orders", orders);

        return "home";
    }

}
