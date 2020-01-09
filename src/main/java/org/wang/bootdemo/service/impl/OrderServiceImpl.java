package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.mapper.OrderMapper;
import org.wang.bootdemo.model.Order;
import org.wang.bootdemo.service.OrderService;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description 订单服务类实例类
 * @Author wangHao
 * @DATE 2020/1/9 22:11
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }
    @Override
    public int addOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public int deleteOrderByOrderId(int orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int updateOrderByOrderId(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return orderMapper.getOrderByUserId(userId);
    }
}
