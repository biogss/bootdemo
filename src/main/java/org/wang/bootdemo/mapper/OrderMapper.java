package org.wang.bootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.wang.bootdemo.model.Order;
import org.wang.bootdemo.model.User;

import java.util.List;

/**
 * 订单mapper类
 * @author wnaghao
 */
@Repository
@Mapper
public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated
     */
    Order selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Order record);

    /**
     * @description 根据用户编号查询订单信息
     * @author wangHao
     * @date 2020/1/9 22:31
     * @param [userId]
     * @return java.util.List<org.wang.bootdemo.model.Order>
     */
    List<Order> getOrderByUserId(int userId);
}