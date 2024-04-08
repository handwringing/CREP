package com.crep.mapper;

import com.crep.entity.Order;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM `order` WHERE order_id = #{orderId}")
    Order selectByPrimaryKey(@Param("orderId") Integer orderId);

    @Insert("INSERT INTO `order` (user_id, item_id, start_time, end_time, total_amount, order_status) " +
            "VALUES (#{userId}, #{itemId}, #{startTime}, #{endTime}, #{totalAmount}, #{orderStatus})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    int insert(Order order);

    @Update("UPDATE `order` SET user_id = #{userId}, item_id = #{itemId}, start_time = #{startTime}, " +
            "end_time = #{endTime}, total_amount = #{totalAmount}, order_status = #{orderStatus} " +
            "WHERE order_id = #{orderId}")
    int updateByPrimaryKey(Order order);

    @Delete("DELETE FROM `order` WHERE order_id = #{orderId}")
    int deleteByPrimaryKey(@Param("orderId") Integer orderId);

    @Select("SELECT * FROM `order`")
    List<Order> selectAllOrders();

    // Add more methods as needed...
}