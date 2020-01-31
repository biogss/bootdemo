package org.wang.bootdemo.org.wang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.wang.bootdemo.BootdemoApplication;
import org.wang.bootdemo.model.Order;
import org.wang.bootdemo.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderServiceTest
 * @Description 测试订单服务类
 * @Author wangHao
 * @DATE 2020/1/9 22:34
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootdemoApplication.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private Order order;

    //StringRedisTemplate<String, String> stringStringRedisTemplate
    @Test
    public void execute(){
        order.setUserId(1);
        order.setProductId(1);
        order.setOrderMoney(100.00);
        order.setOrderStatus("0");
        order.setPayway("1");
        order.setCreateTime(new Date());
        int row = orderService.addOrder(order);
    }

    @Test
    public void execute2(){
        order.setOrderId(1);
        order.setOrderStatus("1");
        order.setUpdateTime(new Date());
        int row = orderService.updateOrderByOrderId(order);
    }

    @Test
    public void execute3(){
        Order orderInfo = orderService.getOrderByOrderId(1);
        System.out.println(orderInfo.toString());
    }

    @Test
    public void execute4(){
        List<Order> orderList = orderService.getOrderByUserId(1);
    }

    @Test
    public void execute5(){
        int row = orderService.deleteOrderByOrderId(1);
    }

}
