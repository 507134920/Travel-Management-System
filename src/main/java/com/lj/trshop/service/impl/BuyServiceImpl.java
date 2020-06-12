package com.lj.trshop.service.impl;

import com.lj.trshop.dao.BuyDao;
import com.lj.trshop.entity.Order;
import com.lj.trshop.entity.Route;
import com.lj.trshop.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyServiceImpl implements BuyService {
    @Autowired
    private BuyDao buyDao;

    @Override
    public Map<String, Object> buyOrder(Integer rid) {
        List<Map<String,Object>> list=buyDao.buyOrder(rid);
        Map<String,Object> map= new HashMap<>();
        map.put("list",list);
        return map;
    }

    @Override
    public boolean saveOrder(Order order) {
        buyDao.saveOrder(order);
        return true;
    }

    @Override
    public boolean updateStates(Integer id) {
        buyDao.updateStates(id);
        return true;
    }

    @Override
    public boolean updateNum(Integer id) {
        buyDao.updateNum(id);
        return true;
    }

    @Override
    public int findNum(Integer rid) {
        int num1 = buyDao.findNum1(rid);
        int num2 = buyDao.findNum2(rid);
        int num = num2-num1;
        return num;
    }

    @Override
    public void insertOrder(Integer rid, Integer num, float money, String name) {
        int n = buyDao.insertOrder(rid, num, money, name);
        if(n>0){
            System.out.println("成功加入订单");
        }else {
            System.out.println("加入订单失败");
        }

    }

    @Override
    public Map<String, Object> findCar(String name) {
        List<Map<String,Object>> list=buyDao.findCar(name);
        Map<String,Object> map= new HashMap<>();
        map.put("list",list);
        return map;
    }

    @Override
    public boolean dleteCar(Integer id) {
        Integer dleteCar = buyDao.dleteCar(id);
        if (dleteCar > 0){
            return true;
        }
        return false;
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = buyDao.getOrderById(id);
        return order;
    }

    @Override
    public Route getRouteById(Integer id) {
        Route route = buyDao.getRouteById(id);
        return route;
    }

}
