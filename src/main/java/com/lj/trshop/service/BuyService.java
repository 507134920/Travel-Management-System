package com.lj.trshop.service;

import com.lj.trshop.entity.Order;
import com.lj.trshop.entity.Route;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface BuyService {

    Map<String,Object> buyOrder(Integer rid);

    //将订单保存到数据库
    boolean saveOrder(Order order);
    //根据订单id修改订单状态
    boolean updateStates(Integer id);
    //支付成功后修改库存
    boolean updateNum(Integer id);
    //查询库存
    int findNum(Integer rid);

    //新增订单
    void insertOrder(@Param("rid")Integer rid,@Param("num") Integer num,
                    @Param("money")float money,@Param("name")String name);

    Map<String,Object> findCar(String name);

    //取消支付
    boolean dleteCar(Integer id);
    
    //阿里支付
    Order getOrderById(Integer id);
    Route getRouteById(Integer id);
}
