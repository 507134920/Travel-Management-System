package com.lj.trshop.service;

import com.lj.trshop.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class TestBuyService extends BaseTest {
    @Autowired
    private BuyService buyService;

    @Test
    public void order(){
        Map<String,Object> map=buyService.buyOrder(4);
        System.out.println(map);
    }
    @Test
    public void num(){
        int num = buyService.findNum(4);
        System.out.println(num);
    }

    @Test
    public void findCar(){
        Map<String, Object> map = buyService.findCar("张三");
        System.out.println(map);
    }
}
