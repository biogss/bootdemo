package org.wang.bootdemo.service;

import org.wang.bootdemo.model.Order;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description 新增订单服务类接口
 * @Author wangHao
 * @DATE 2020/1/9 22:06
 * @Version 1.0
 */
public interface OrderService {

    /**
     * @description 新增订单
     * @author wangHao
     * @date 2020/1/9 22:07
     * @param [order]
     * @return int
     */
    int addOrder(Order order);

    /**
     * @description 根据订单编号删除订单
     * @author wangHao
     * @date 2020/1/9 22:08
     * @param [orderId]
     * @return int
     */
    int deleteOrderByOrderId(int orderId);

    /**
     * @description 修改订单
     * @author wangHao
     * @date 2020/1/9 22:09
     * @param [orderId]
     * @return int
     */
    int updateOrderByOrderId(Order order);

    /**
     * @description 根据订单编号查询订单信息
     * @author wangHao
     * @date 2020/1/9 22:10
     * @param [orderId]
     * @return org.wang.bootdemo.model.Order
     */
    Order getOrderByOrderId(int orderId);

    /**
     * @description 根据用户编号查询订单信息
     * @author wangHao
     * @date 2020/1/9 22:10
     * @param [userId]
     * @return java.util.List<org.wang.bootdemo.model.Order>
     */
    List<Order> getOrderByUserId(int userId);
}
