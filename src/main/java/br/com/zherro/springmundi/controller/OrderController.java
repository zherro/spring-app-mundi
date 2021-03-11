package br.com.zherro.springmundi.controller;

import br.com.zherro.springmundi.model.Order;
import br.com.zherro.springmundi.model.OrderStatus;
import br.com.zherro.springmundi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("form")
    public String form(Order order){
        return "orderForm";
    }

    @PostMapping("new")
    public String newOrder(@Valid Order order, BindingResult result) {

        if(result.hasErrors()) {
            return "orderForm";
        }

    System.out.println("tesskjjjkhj");

        order.setStatus(OrderStatus.WAITING);
        orderService.save(order);
        return "redirect:/home";
    }

    @GetMapping("all/{status}")
    public String byStatus(@PathVariable("status") String status, Model model){

        List<Order> orders = orderService.findByStatus(OrderStatus.valueOf(status.toUpperCase()));
        model.addAttribute("orders", orders);

        return "home";
    }
}
