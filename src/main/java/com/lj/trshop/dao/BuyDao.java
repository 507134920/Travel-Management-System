package com.lj.trshop.dao;

import com.lj.trshop.entity.Order;
import com.lj.trshop.entity.Product;
import com.lj.trshop.entity.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BuyDao {
    List<Map<String,Object>> buyOrder(@Param("rid")Integer rid);

    //将订单保存到数据库
    void saveOrder(Order order);
    //根据订单id修改订单状态
    void updateStates(@Param("id")Integer id);

    //查询库存
    int findNum1(@Param("rid")Integer rid);
    int findNum2(@Param("rid")Integer rid);

    //新增订单
    int insertOrder(@Param("rid")Integer rid,@Param("num") Integer num,@Param("money")float money, @Param("name")String name);

    //购物车
    List<Map<String,Object>> findCar(@Param("name")String name);
    //取消支付
    Integer dleteCar(@Param("id")Integer id);
    //支付成功后根据产品id修改库存
    void updateNum(@Param("id")Integer id);


    //阿里支付
    Order getOrderById(@Param("id")Integer id);
    Route getRouteById(@Param("id")Integer id);
    void updateStatesBycode(@Param("code")String code);
}
