package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.mapper.OrderMapper;
import org.wang.bootdemo.model.Order;
import org.wang.bootdemo.service.OrderService;

import javax.annotation.Resource;
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

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Override
    public int addOrder(Order order) {

//        return orderMapper.insertSelective(order);

        redisTemplate.opsForValue().set("order1", order);
        return 1;
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
        return (Order) redisTemplate.opsForValue().get("order1");
//        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Order> getOrderByUserId(int userId) {

        return orderMapper.getOrderByUserId(userId);
    }
}
