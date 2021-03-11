package br.com.zherro.springmundi.service;

import br.com.zherro.springmundi.model.Order;
import br.com.zherro.springmundi.model.OrderStatus;
import br.com.zherro.springmundi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> orderList(){
        var orders = repository.findAll();

        revertOrderList(orders);
        return orders;
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public List<Order> findByStatus(OrderStatus status) {
        var orders = repository.findByStatus(status);

        revertOrderList(orders);
        return orders;
    }


    private void revertOrderList(List<Order> orders) {
        Collections.sort(orders, (order, t1) -> Long.compare(t1.getId(), order.getId()));
    }
}
