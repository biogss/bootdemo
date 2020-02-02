package org.wang.bootdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.wang.bootdemo.mapper.OrderMapper;
import org.wang.bootdemo.model.Order;
import org.wang.bootdemo.service.OrderService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

//        redisTemplate.opsForValue().set("order1", order,1000, TimeUnit.SECONDS);
//        redisTemplate.opsForList().leftPush("mylist", order);
//        redisTemplate.opsForList().leftPush("mylist", "123");
//        redisTemplate.opsForList().leftPush("mylist", "456");
//        redisTemplate.opsForList().rightPush("mylist", "abc");
        redisTemplate.opsForHash().put("myhash", "1", order);
        return 1;
    }

    @Override
    public int deleteOrderByOrderId(int orderId) {
//        return orderMapper.deleteByPrimaryKey(orderId);
        redisTemplate.opsForList().trim("mylist", 1, 0);
        return 1;
    }

    @Override
    public int updateOrderByOrderId(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
//        return (Order) redisTemplate.opsForValue().get("order1");
        return orderMapper.selectByPrimaryKey(orderId);

    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        List<Object> redisList = redisTemplate.opsForList().range("mylist", 0, -1);
        List<Order> orderList = new ArrayList<>();
        if (redisList != null){
            for (Object object : redisList){
                orderList.add((Order) object);
            }
        }
        return orderList;
//        return orderMapper.getOrderByUserId(userId);
    }
}
