package com.crep.service;

import com.crep.entity.Order;
import java.util.List;

public interface OrderService {
    Order getOrderById(Integer orderId);
    List<Order> getAllOrders();
    boolean createOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(Integer orderId);
}