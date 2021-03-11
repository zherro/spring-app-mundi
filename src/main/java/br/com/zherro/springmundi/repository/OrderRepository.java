package br.com.zherro.springmundi.repository;

import br.com.zherro.springmundi.model.Order;
import br.com.zherro.springmundi.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
}
