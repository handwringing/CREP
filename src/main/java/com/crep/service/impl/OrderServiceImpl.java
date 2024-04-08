package com.crep.service.impl;

import com.crep.entity.Order;
import com.crep.mapper.OrderMapper;
import com.crep.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderMapper.selectAllOrders();
    }

    @Override
    @Transactional
    public boolean createOrder(Order order) {
        return orderMapper.insert(order) > 0;
    }

    @Override
    @Transactional
    public boolean updateOrder(Order order) {
        return orderMapper.updateByPrimaryKey(order) > 0;
    }

    @Override
    @Transactional
    public boolean deleteOrder(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId) > 0;
    }
}